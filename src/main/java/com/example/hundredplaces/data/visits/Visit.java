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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(long placeId) {
        this.placeId = placeId;
    }

    public LocalDateTime getDateVisited() {
        return dateVisited;
    }

    public void setDateVisited(LocalDateTime dateVisited) {
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
