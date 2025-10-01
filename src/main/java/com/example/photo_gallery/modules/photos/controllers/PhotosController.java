package com.example.photo_gallery.modules.photos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.photo_gallery.modules.photos.dto.UploadPhotoDTO;
import com.example.photo_gallery.modules.photos.dto.UploadPhotoResponseDTO;
import com.example.photo_gallery.modules.photos.services.UploadPhotoService;

@RestController
@RequestMapping("/photos")
public class PhotosController {

    @Autowired
    private UploadPhotoService uploadPhotoService;

    @PostMapping("upload")
    public ResponseEntity<UploadPhotoResponseDTO> onSave(@RequestBody UploadPhotoDTO payload) {
        return ResponseEntity.status(HttpStatus.CREATED).body(uploadPhotoService.execute(payload));
    }

}
