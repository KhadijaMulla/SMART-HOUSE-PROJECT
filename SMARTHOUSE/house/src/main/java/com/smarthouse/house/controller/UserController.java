package com.smarthouse.house.controller;

import com.smarthouse.house.dto.LoginRequestDTO;
import com.smarthouse.house.dto.UserResponseDTO;
import com.smarthouse.house.entity.User;
import com.smarthouse.house.service.JwtService;
import com.smarthouse.house.service.UserService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public UserController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtService jwtService) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {

        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginRequest) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        return jwtService.generateToken(loginRequest.getEmail());
    }
}