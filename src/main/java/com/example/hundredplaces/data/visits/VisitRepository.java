package com.example.hundredplaces.data.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {

    @Query("SELECT dateVisited FROM Visit WHERE userId = :userId AND placeId = :placeId")
    List<LocalDateTime> findVisitDatesByUserIdAndPlaceId(
            @Param("userId") long userId,
            @Param("placeId") long placeId
    );
}
