package com.example.hundredplaces.data.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

    List<Visit> findAllByUserId(int userId);

    @Transactional
    default void insertAll(List<Visit> visits) {
        for (Visit visit : visits) {
            insertVisit(visit.getId(), visit.getUserId(), visit.getPlaceId(), visit.getDateVisited());
        }
    }

    @Modifying
    @Transactional
    @Query("INSERT INTO Visit (id, userId, placeId, dateVisited)" +
            "SELECT :id, :userId, :placeId, :dateVisited " +
            "WHERE NOT EXISTS (" +
            "SELECT 1 " +
            "FROM Visit " +
            "WHERE userId = :userId " +
            "AND placeId = :placeId " +
            "AND DATE(dateVisited) = DATE(:dateVisited)" +
            ")")
    void insertVisit(
            @Param("id") UUID id,
            @Param("userId") int userId,
            @Param("placeId") int placeId,
            @Param("dateVisited") Instant dateVisited);
}
