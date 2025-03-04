package com.example.hundredplaces.business.services;

import com.example.hundredplaces.data.place.Place;
import com.example.hundredplaces.data.place.PlaceRepository;
import com.example.hundredplaces.data.usersPlacesPreferences.UsersPlacesPreferencesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final UsersPlacesPreferencesRepository usersPlacesPreferencesRepository;

    public PlaceService(PlaceRepository placeRepository, UsersPlacesPreferencesRepository usersPlacesPreferencesRepository) {
        this.placeRepository = placeRepository;
        this.usersPlacesPreferencesRepository = usersPlacesPreferencesRepository;
    }

    public void updatePlacesRatings() {
        List<Place> places = placeRepository.findAll();
        for (Place place : places) {
            Double rating = usersPlacesPreferencesRepository.getAvgRatingByPlaceId(place.getId());
            if (rating != null) {
                place.setRating(rating);
            }
        }
    }
}
