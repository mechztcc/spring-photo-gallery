package com.example.photo_gallery.modules.user.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.user.dto.UserDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping("/create")
    public UserDTO onSave(@Valid @RequestBody UserDTO user) {
        return user;
    }

}
