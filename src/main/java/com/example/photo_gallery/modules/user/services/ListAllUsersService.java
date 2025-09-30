package com.example.photo_gallery.modules.user.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.photo_gallery.modules.user.model.User;
import com.example.photo_gallery.modules.user.repositories.UsersRepository;

import org.springframework.data.domain.Page;          // ✅ vem do Spring Data
import org.springframework.data.domain.Pageable;      // ✅ vem do Spring Data
import org.springframework.data.domain.PageRequest;   // ✅ vem do Spring Data

@Service
public class ListAllUsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Page<User> execute(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usersRepository.findAll(pageable);
    }
}
