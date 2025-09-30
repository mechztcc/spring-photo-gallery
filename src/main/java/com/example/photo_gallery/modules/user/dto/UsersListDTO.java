package com.example.photo_gallery.modules.user.dto;

import com.example.photo_gallery.modules.user.model.User;

public class UsersListDTO {

    public UsersListDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    private Long id;

    private String name;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User toEntity() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
