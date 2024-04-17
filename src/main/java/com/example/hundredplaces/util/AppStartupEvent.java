package com.example.hundredplaces.util;

import com.example.hundredplaces.business.objects.PlaceWithCityAndImages;
import com.example.hundredplaces.business.services.PlaceWithCityAndImagesService;
import com.example.hundredplaces.data.user.User;
import com.example.hundredplaces.data.user.UserRepository;
import com.example.hundredplaces.data.visits.VisitRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final VisitRepository visitRepository;
    private final PlaceWithCityAndImagesService placeWithCityAndImagesService;

    public AppStartupEvent(UserRepository userRepository, VisitRepository visitRepository, PlaceWithCityAndImagesService placeWithCityAndImagesService) {
        this.userRepository = userRepository;
        this.visitRepository = visitRepository;
        this.placeWithCityAndImagesService = placeWithCityAndImagesService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        User user1 = userRepository.findByEmailAndPassword("anangelov@tu-sofia.bg", "1234");
        User user2 = userRepository.findByEmailAndPassword("wrong@email.com", "1234");
        System.out.println(user1);
        System.out.println(user2);

        List<LocalDateTime> visit1 = visitRepository.findVisitDatesByUserIdAndPlaceId(1, 1);
        List<LocalDateTime> visit2 = visitRepository.findVisitDatesByUserIdAndPlaceId(1, 2);
        visit1.forEach(System.out::println);
        visit2.forEach(System.out::println);

        List<PlaceWithCityAndImages> places = placeWithCityAndImagesService.getPlacesWithCityAndImages();
        places.forEach(System.out::println);
    }
}
