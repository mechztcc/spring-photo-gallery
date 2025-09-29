package com.example.photo_gallery.modules.user.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping("/create")
    public String onSave(@RequestBody String name) {
        return name;
    }

    @GetMapping()
    public String onUpdate() {
        return "onUpdate works";
    }

}
