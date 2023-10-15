package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.ArClothesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/arClothes",  produces = "application/json;charset=utf8")
public class ArClothesController {
    private final ArClothesService arClothesService;

    public ArClothesController(ArClothesService arClothesService) {
        this.arClothesService = arClothesService;
    }
}
