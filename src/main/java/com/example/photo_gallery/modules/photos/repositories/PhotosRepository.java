package com.example.photo_gallery.modules.photos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.photo_gallery.modules.photos.model.Photo;

public interface PhotosRepository extends JpaRepository<Photo, Long> {

}
