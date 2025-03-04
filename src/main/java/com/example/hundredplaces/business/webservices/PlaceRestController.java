package com.example.hundredplaces.business.webservices;

import com.example.hundredplaces.data.place.Place;
import com.example.hundredplaces.data.place.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/places")
public class PlaceRestController {
    private final PlaceRepository placeRepository;

    public PlaceRestController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping()
    public List<Place> getAllCities() {
        return placeRepository.findAll();
    }


//    Unused mappings

//    @GetMapping("/place/plain")
//    public Place getPlaceById(@RequestParam int id) {
//        return placeRepository.findById(id);
//    }
//
//    @PostMapping("/new")
//    public Place createPlace(@RequestBody Place place) {
//        return placeRepository.save(place);
//    }
//
//    @PutMapping("/update")
//    public Place updatePlace(@RequestBody Place place) {
//        return placeRepository.save(place);
//    }
//
//    @DeleteMapping("/delete")
//    public void deletePlaceById(@RequestParam int id) {
//        placeRepository.deleteById(id);
//    }
}
