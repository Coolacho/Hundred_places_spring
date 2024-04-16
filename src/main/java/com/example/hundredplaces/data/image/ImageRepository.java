package com.example.hundredplaces.data.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findById(long id);
    List<Image> findAllByPlaceId(Long placeId);
}
