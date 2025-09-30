package com.example.photo_gallery.modules.users.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.users.dto.UserDTO;
import com.example.photo_gallery.modules.users.dto.UsersListDTO;
import com.example.photo_gallery.modules.users.model.User;
import com.example.photo_gallery.modules.users.services.CreateUserService;
import com.example.photo_gallery.modules.users.services.ListAllUsersService;

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
    public Page<UsersListDTO> onListAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return listAllUsersService.execute(page, size);
    }

}
