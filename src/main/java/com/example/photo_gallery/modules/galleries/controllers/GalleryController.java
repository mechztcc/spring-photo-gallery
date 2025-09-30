package com.example.photo_gallery.modules.galleries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.galleries.dto.GalleryDTO;
import com.example.photo_gallery.modules.galleries.model.Gallery;
import com.example.photo_gallery.modules.galleries.services.CreateGalleryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/galleries")
public class GalleryController {

    @Autowired
    private CreateGalleryService createGalleryService;

    @PostMapping("/create")
    public Gallery onSave(@RequestBody GalleryDTO gallery) {
        return createGalleryService.execute(gallery);
    }

}
