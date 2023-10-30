package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.Prefer;
import com.example.puddyBuddy.dto.prefer.PreferDTO;
import com.example.puddyBuddy.service.PreferService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping( value = "/prefers",  produces = "application/json;charset=utf8")
public class PreferController {
    private final PreferService preferService;
    public PreferController(PreferService preferService) {
        this.preferService = preferService;
    }

    @GetMapping
    public ResponseEntity<List<PreferDTO>> getAllPreferDTOs() {
        List<PreferDTO> result = preferService.getAllPreferDTOs();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/raw")
    public ResponseEntity<List<Prefer>> getAllPrefers() {
        List<Prefer> result = preferService.getPrefers();
        return ResponseEntity.ok(result);
    }
}
