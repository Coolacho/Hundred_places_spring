package com.example.hundredplaces.business.objects;

import com.example.hundredplaces.data.user.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserWithVisits {
    private User user;
    private Map<Long, List<Date>> visits;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Long, List<Date>> getVisits() {
        return visits;
    }

    public void setVisits(Map<Long, List<Date>> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "UserWithVisits{" +
                "user=" + user +
                ", visits=" + visits +
                '}';
    }
}
