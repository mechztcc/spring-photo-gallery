package com.example.photo_gallery.modules.galleries.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.galleries.dto.GalleryDTO;
import com.example.photo_gallery.modules.galleries.model.Gallery;
import com.example.photo_gallery.modules.galleries.services.CreateGalleryService;
import com.example.photo_gallery.modules.galleries.services.ListGalleryService;

@RestController
@RequestMapping("/galleries")
public class GalleryController {

    @Autowired
    private CreateGalleryService createGalleryService;

    @Autowired
    private ListGalleryService listGalleryService;

    @PostMapping("/create")
    public Gallery onSave(@RequestBody GalleryDTO gallery) {
        return createGalleryService.execute(gallery);
    }

    @GetMapping("/list")
    public Page<Gallery> onListAll(@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        return listGalleryService.execute(page, size);
    }

}
