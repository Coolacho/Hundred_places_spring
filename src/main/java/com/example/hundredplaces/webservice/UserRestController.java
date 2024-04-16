package com.example.hundredplaces.webservice;

import com.example.hundredplaces.business.objects.UserWithVisits;
import com.example.hundredplaces.business.services.UserWithVisitsService;
import com.example.hundredplaces.data.user.User;
import com.example.hundredplaces.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserRepository userRepository;
    private final UserWithVisitsService userWithVisitsService;

    public UserRestController(UserRepository userRepository, UserWithVisitsService userWithVisitsService) {
        this.userRepository = userRepository;
        this.userWithVisitsService = userWithVisitsService;
    }

    @GetMapping("/all")
    public List<User> getAllCities() {
        return userRepository.findAll();
    }

    @GetMapping("/user/plain")
    public User getUserById(@RequestParam long id) {
        return userRepository.findById(id);
    }

    @GetMapping("/user/filled")
    public UserWithVisits getUserWithVisits(@RequestParam long id) {
        return userWithVisitsService.getUserWithVisits(id);
    }

    @PostMapping("/new")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteUserById(@RequestParam long id) {
        userRepository.deleteById(id);
    }
}
