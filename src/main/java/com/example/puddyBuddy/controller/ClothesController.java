package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.ClothesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/clothes",  produces = "application/json;charset=utf8")
public class ClothesController {
    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }
}
