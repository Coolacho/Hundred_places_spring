package com.example.hundredplaces.data.visits;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(
            name = "user_id",
            nullable = false
    )
    private long userId;

    @Column(
            name = "place_id",
            nullable = false
    )
    private long placeId;

    @Column(
            name = "date_visited",
            nullable = false
    )
    private LocalDateTime dateVisited;
}
