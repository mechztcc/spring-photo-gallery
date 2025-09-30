package com.example.photo_gallery.modules.users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.users.dto.UserDTO;
import com.example.photo_gallery.modules.users.model.User;
import com.example.photo_gallery.modules.users.repositories.UsersRepository;

@Service
public class CreateUserService {

    @Autowired
    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User execute(UserDTO user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(user.toEntity());
    }
}
