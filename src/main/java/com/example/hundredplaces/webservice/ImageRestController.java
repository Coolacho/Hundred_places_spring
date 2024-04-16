package com.example.hundredplaces.webservice;

import com.example.hundredplaces.data.image.Image;
import com.example.hundredplaces.data.image.ImageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
public class ImageRestController {
    private final ImageRepository imageRepository;

    public ImageRestController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping("/all")
    public List<Image> getAllCities() {
        return imageRepository.findAll();
    }

    @GetMapping("/image")
    public Image getImageById(@RequestParam long id) {
        return imageRepository.findById(id);
    }

    @PostMapping("/new")
    public Image createImage(@RequestBody Image image) {
        return imageRepository.save(image);
    }

    @PutMapping("/update")
    public Image updateImage(@RequestBody Image image) {
        return imageRepository.save(image);
    }

    @DeleteMapping("/delete")
    public void deleteImageById(@RequestParam long id) {
        imageRepository.deleteById(id);
    }
}
