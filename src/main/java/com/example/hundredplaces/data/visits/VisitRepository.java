package com.example.hundredplaces.data.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Long> {
    Visit findById(long Id);

    @Query("SELECT v.placeId, v.dateVisited FROM Visit v WHERE v.userId = :userId")
    List<Object[]> findVisitDatesByUserId(@Param("userId") long userId);
}
