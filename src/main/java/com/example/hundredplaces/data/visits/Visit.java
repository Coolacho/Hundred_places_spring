package com.example.hundredplaces.data.visits;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "place_id")
    private long placeId;

    @Column(name = "date_visited")
    private Date dateVisited;
}
