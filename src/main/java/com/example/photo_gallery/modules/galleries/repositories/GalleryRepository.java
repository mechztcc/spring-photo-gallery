package com.example.photo_gallery.modules.galleries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.photo_gallery.modules.galleries.model.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

}
