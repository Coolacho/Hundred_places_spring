package com.example.hundredplaces.business.services;

import com.example.hundredplaces.business.objects.UserWithVisits;
import com.example.hundredplaces.data.user.User;
import com.example.hundredplaces.data.user.UserRepository;
import com.example.hundredplaces.data.visits.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserWithVisitsService {
    private final UserRepository userRepository;
    private final VisitRepository visitRepository;

    public UserWithVisitsService(UserRepository userRepository, VisitRepository visitRepository) {
        this.userRepository = userRepository;
        this.visitRepository = visitRepository;
    }

    public UserWithVisits getUserWithVisits(long userId) {
        UserWithVisits userWithVisits = new UserWithVisits();
        User user = userRepository.findById(userId);
        userWithVisits.setUser(user);

        List<Object[]> results = visitRepository.findVisitDatesByUserId(userId);
        Map<Long, List<Date>> visitMap = new HashMap<>();
        for (Object[] result : results) {
            long placeId = (long) result[0];
            Date dateVisited = (Date) result[1];

            visitMap.computeIfAbsent(placeId, k -> new ArrayList<>()).add(dateVisited);
        }

        userWithVisits.setVisits(visitMap);
        return userWithVisits;
    }
}
