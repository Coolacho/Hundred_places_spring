package com.example.hundredplaces.data.usersPlacesPreferences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

public interface UsersPlacesPreferencesRepository extends JpaRepository<UsersPlacesPreferences, Integer> {

    List<UsersPlacesPreferences> findAllByUserId(int userId);

    @Query("SELECT AVG(rating) FROM UsersPlacesPreferences WHERE placeId = :placeId")
    Double getAvgRatingByPlaceId(@Param("placeId") int placeId);

    @Transactional
    default void insertAll(List<UsersPlacesPreferences> usersPlacesPreferences) {
        for (UsersPlacesPreferences usersPlacesPreference : usersPlacesPreferences) {
            System.out.println(usersPlacesPreference);
            insertUsersPlacesPreferences(
                    usersPlacesPreference.getUserId(),
                    usersPlacesPreference.getPlaceId(),
                    usersPlacesPreference.getRating(),
                    usersPlacesPreference.getIsFavorite(),
                    usersPlacesPreference.getLastUpdate()
            );
        }
    }

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users_places_preferences (user_id, place_id, rating, is_favorite, last_update)" +
            "SELECT :userId, :placeId, :rating, :isFavorite, :lastUpdate " +
            "WHERE NOT EXISTS (" +
            "SELECT 1 " +
            "FROM users_places_preferences " +
            "WHERE user_id = :userId " +
            "AND place_id = :placeId " +
            "AND last_update > :lastUpdate" +
            ") ON DUPLICATE KEY UPDATE " +
            "rating = :rating, " +
            "is_favorite = :isFavorite, " +
            "last_update = :lastUpdate",
    nativeQuery = true)
    void insertUsersPlacesPreferences(
            @Param("userId") int userId,
            @Param("placeId") int placeId,
            @Param("rating") double rating,
            @Param("isFavorite") boolean isFavorite,
            @Param("lastUpdate") Instant lastUpdate
    );
}
