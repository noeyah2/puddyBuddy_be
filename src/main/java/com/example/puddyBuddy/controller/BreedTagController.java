package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.BreedTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/breedTags",  produces = "application/json;charset=utf8")
public class BreedTagController {
    private final BreedTagService breedTagService;

    public BreedTagController(BreedTagService breedTagService) {
        this.breedTagService = breedTagService;
    }
}
