package com.example.hundredplaces.data.usersPlacesPreferences;

import java.io.Serializable;
import java.util.Objects;

public class UsersPlacesPreferencesId implements Serializable {

    private int userId;

    private int placeId;

    public UsersPlacesPreferencesId() {}

    public UsersPlacesPreferencesId(int userId, int placeId) {
        this.userId = userId;
        this.placeId = placeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersPlacesPreferencesId usersPlacesPreferencesId)) return false;
        return userId == usersPlacesPreferencesId.userId && placeId == usersPlacesPreferencesId.placeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, placeId);
    }

}
