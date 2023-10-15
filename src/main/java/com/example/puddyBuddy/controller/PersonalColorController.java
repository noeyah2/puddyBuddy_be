package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.PersonalColorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/personalColors",  produces = "application/json;charset=utf8")
public class PersonalColorController {
    private final PersonalColorService personalColorService;

    public PersonalColorController(PersonalColorService personalColorService) {
        this.personalColorService = personalColorService;
    }
}
