package com.example.hundredplaces.business.webservices;

import com.example.hundredplaces.data.city.City;
import com.example.hundredplaces.data.city.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityRestController {
    private final CityRepository cityRepository;

    public CityRestController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping()
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

//    Unused mappings
//    @GetMapping("/city")
//    public City getCityById(@RequestParam int id) {
//        return cityRepository.findById(id);
//    }
//
//    @PostMapping("/new")
//    public City createCity(@RequestBody City city) {
//        return cityRepository.save(city);
//    }
//
//    @PutMapping("/update")
//    public City updateCity(@RequestBody City city) {
//        return cityRepository.save(city);
//    }
//
//    @DeleteMapping("/delete")
//    public void deleteCityById(@RequestParam int id) {
//        cityRepository.deleteById(id);
//    }
}
