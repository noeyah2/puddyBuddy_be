package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.service.PreferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( value = "/prefers",  produces = "application/json;charset=utf8")
public class PreferController {
    private final PreferService preferService;

    public PreferController(PreferService preferService) {
        this.preferService = preferService;
    }
}
