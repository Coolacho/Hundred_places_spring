package com.example.hundredplaces.webservice;

import com.example.hundredplaces.data.user.User;
import com.example.hundredplaces.data.user.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {
    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam String email, @RequestParam String password) {
        return userRepository.findByEmailAndPassword(email, password);
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
