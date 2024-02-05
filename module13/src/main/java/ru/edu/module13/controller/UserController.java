package ru.edu.module13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.edu.module13.entity.User;
import ru.edu.module13.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));

        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

}
