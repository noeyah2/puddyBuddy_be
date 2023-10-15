package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.ClothesPhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/clothesPhotos",  produces = "application/json;charset=utf8")
public class ClothesPhotoController {
    private final ClothesPhotoService clothesPhotoService;

    public ClothesPhotoController(ClothesPhotoService clothesPhotoService) {
        this.clothesPhotoService = clothesPhotoService;
    }
}
