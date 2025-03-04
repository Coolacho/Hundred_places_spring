package com.example.hundredplaces.data.usersPlacesPreferences;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@IdClass(UsersPlacesPreferencesId.class)
@Table(name = "users_places_preferences")
public class UsersPlacesPreferences {
    @Id
    private int userId;

    @Id
    private int placeId;

    @Column(
            name = "rating",
            nullable = false
    )
    private double rating;

    @Column(
            name = "is_favorite",
            nullable = false
    )
    private boolean isFavorite;

    @Column(
            name = "last_update",
            nullable = false
    )
    private Instant lastUpdate;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "UsersPlacesPreferences{" +
                "userId=" + userId +
                ", placeId=" + placeId +
                ", rating=" + rating +
                ", isFavorite=" + isFavorite +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
