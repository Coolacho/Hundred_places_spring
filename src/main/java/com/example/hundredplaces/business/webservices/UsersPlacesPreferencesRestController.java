package com.example.hundredplaces.business.webservices;

import com.example.hundredplaces.business.services.PlaceService;
import com.example.hundredplaces.data.usersPlacesPreferences.UsersPlacesPreferences;
import com.example.hundredplaces.data.usersPlacesPreferences.UsersPlacesPreferencesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usersPlacesPreferences")
public class UsersPlacesPreferencesRestController {
    private final UsersPlacesPreferencesRepository usersPlacesPreferencesRepository;
    private final PlaceService placeService;

    public UsersPlacesPreferencesRestController(UsersPlacesPreferencesRepository usersPlacesPreferencesRepository, PlaceService placeService) {
        this.usersPlacesPreferencesRepository = usersPlacesPreferencesRepository;
        this.placeService = placeService;
    }

    @GetMapping()
    public List<UsersPlacesPreferences> getAllUsersPlacesReferencesByUserId(@RequestParam("userId") int userId) {
        return usersPlacesPreferencesRepository.findAllByUserId(userId);
    }

    @PostMapping("/new")
    public void insertAllUsersPlacesPreferences(@RequestBody List<UsersPlacesPreferences> usersPlacesPreferences) {
        usersPlacesPreferencesRepository.insertAll(usersPlacesPreferences);
        placeService.updatePlacesRatings();
    }

}
