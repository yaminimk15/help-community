package com.help.community.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.community.model.User;
import com.help.community.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // ✅ SIGNUP (ADD USER)
    @PostMapping
    public User add(@RequestBody User user) {
        return repo.save(user);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return repo.findAll().stream()
                .filter(u -> u.getEmail().equals(user.getEmail())
                        && u.getPassword().equals(user.getPassword()))
                .findFirst()
                .orElse(null);
    }

    // ✅ GET ALL USERS (optional)
    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }
}