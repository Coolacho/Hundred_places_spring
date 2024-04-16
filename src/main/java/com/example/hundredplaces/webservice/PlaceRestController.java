package com.example.hundredplaces.webservice;

import com.example.hundredplaces.business.objects.PlaceWithCityAndImages;
import com.example.hundredplaces.business.services.PlaceWithCityAndImagesService;
import com.example.hundredplaces.data.place.Place;
import com.example.hundredplaces.data.place.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceRestController {
    private final PlaceRepository placeRepository;
    private final PlaceWithCityAndImagesService placeWithCityAndImagesService;

    public PlaceRestController(PlaceRepository placeRepository, PlaceWithCityAndImagesService placeWithCityAndImagesService) {
        this.placeRepository = placeRepository;
        this.placeWithCityAndImagesService = placeWithCityAndImagesService;
    }

    @GetMapping("/all/plain")
    public List<Place> getAllCities() {
        return placeRepository.findAll();
    }

    @GetMapping("/all/filled")
    public List<PlaceWithCityAndImages> getAllPlacesWithCityAndImages() {
        return placeWithCityAndImagesService.getPlaceWithCityAndImages();
    }

    @GetMapping("/place")
    public Place getPlaceById(@RequestParam long id) {
        return placeRepository.findById(id);
    }

    @PostMapping("/new")
    public Place createPlace(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @PutMapping("/update")
    public Place updatePlace(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @DeleteMapping("/delete")
    public void deletePlaceById(@RequestParam long id) {
        placeRepository.deleteById(id);
    }
}
