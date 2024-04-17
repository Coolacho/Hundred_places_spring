package com.example.hundredplaces.business.services;

import com.example.hundredplaces.business.objects.PlaceWithCityAndImages;
import com.example.hundredplaces.data.city.City;
import com.example.hundredplaces.data.city.CityRepository;
import com.example.hundredplaces.data.image.ImageRepository;
import com.example.hundredplaces.data.place.Place;
import com.example.hundredplaces.data.place.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceWithCityAndImagesService {
    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;
    private final ImageRepository imageRepository;

    public PlaceWithCityAndImagesService(PlaceRepository placeRepository, CityRepository cityRepository, ImageRepository imageRepository) {
        this.placeRepository = placeRepository;
        this.cityRepository = cityRepository;
        this.imageRepository = imageRepository;
    }

    private PlaceWithCityAndImages fetchPlaceWithCityAndImages(Place place) {
        PlaceWithCityAndImages placeWithCityAndImage = new PlaceWithCityAndImages();
        placeWithCityAndImage.setPlace(place);

        City city = cityRepository.findById(place.getCityId());
        placeWithCityAndImage.setCity(city.getName());

        List<String> images = new ArrayList<>();
        imageRepository.findAllByPlaceId(place.getId()).forEach(image -> images.add(image.getImagePath()));
        placeWithCityAndImage.setImages(images);
        return placeWithCityAndImage;
    }

    public List<PlaceWithCityAndImages> getPlacesWithCityAndImages() {
        Iterable<Place> places = placeRepository.findAll();
        List<PlaceWithCityAndImages> placesWithCityAndImages = new ArrayList<>();

        for (Place place : places) {
            placesWithCityAndImages.add(fetchPlaceWithCityAndImages(place));
        }

        return placesWithCityAndImages;
    }

    public PlaceWithCityAndImages getPlaceWithCityAndImages(Long id) {
        Place place = placeRepository.findById(id).orElse(null);
        return fetchPlaceWithCityAndImages(place);
    }

}
