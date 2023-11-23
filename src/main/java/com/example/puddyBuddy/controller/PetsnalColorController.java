package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.PetsnalColorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/petsnalColors",  produces = "application/json;charset=utf8")
public class PetsnalColorController {
    private final PetsnalColorService petsnalColorService;


    public PetsnalColorController(PetsnalColorService petsnalColorService) {
        this.petsnalColorService = petsnalColorService;
    }
}
