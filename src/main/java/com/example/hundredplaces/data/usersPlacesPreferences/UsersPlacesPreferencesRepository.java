package com.example.hundredplaces.data.usersPlacesPreferences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersPlacesPreferencesRepository extends JpaRepository<UsersPlacesPreferences, Integer> {

    List<UsersPlacesPreferences> findAllByUserId(int userId);

    @Query("SELECT AVG(rating) FROM UsersPlacesPreferences WHERE placeId = :placeId")
    Double getAvgRatingByPlaceId(@Param("placeId") int placeId);

    @Transactional
    default void insertAll(List<UsersPlacesPreferences> usersPlacesPreferences) {
        for (UsersPlacesPreferences usersPlacesPreference : usersPlacesPreferences) {
            insertUsersPlacesPreferences(
                    usersPlacesPreference.getUserId(),
                    usersPlacesPreference.getPlaceId(),
                    usersPlacesPreference.getRating(),
                    usersPlacesPreference.isFavorite(),
                    usersPlacesPreference.getLastUpdate()
            );
        }
    }

    @Modifying
    @Transactional
    @Query("INSERT INTO UsersPlacesPreferences (userId, placeId, rating, isFavorite, lastUpdate)" +
            "SELECT :userId, :placeId, :rating, :isFavorite, :lastUpdate " +
            "WHERE NOT EXISTS (" +
            "SELECT 1 " +
            "FROM UsersPlacesPreferences " +
            "WHERE userId = :userId " +
            "AND placeId = :placeId " +
            "AND lastUpdate < :lastUpdate" +
            ")")
    void insertUsersPlacesPreferences(
            @Param("userId") int userId,
            @Param("placeId") int placeId,
            @Param("rating") double rating,
            @Param("isFavorite") boolean isFavorite,
            @Param("lastUpdate") LocalDateTime lastUpdate
    );
}
