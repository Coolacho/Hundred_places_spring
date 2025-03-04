package com.example.hundredplaces.data.visits;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(
            name = "user_id",
            nullable = false
    )
    private int userId;

    @Column(
            name = "place_id",
            nullable = false
    )
    private int placeId;

    @Column(
            name = "date_visited",
            nullable = false
    )
    private Instant dateVisited = Instant.now();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public Instant getDateVisited() {
        return dateVisited;
    }

    public void setDateVisited(Instant dateVisited) {
        this.dateVisited = dateVisited;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", userId=" + userId +
                ", placeId=" + placeId +
                ", dateVisited=" + dateVisited +
                '}';
    }
}
