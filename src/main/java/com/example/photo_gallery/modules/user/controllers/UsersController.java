package com.example.photo_gallery.modules.user.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.user.dto.UserDTO;
import com.example.photo_gallery.modules.user.model.User;
import com.example.photo_gallery.modules.user.services.CreateUserService;
import com.example.photo_gallery.modules.user.services.ListAllUsersService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private CreateUserService createUserService;

    @Autowired
    private ListAllUsersService listAllUsersService;

    @PostMapping("/create")
    public User onSave(@Valid @RequestBody UserDTO user) {
        return createUserService.execute(user);
    }

    @GetMapping("/list")
    public Page<User> onListAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return listAllUsersService.execute(page, size);
    }

}
