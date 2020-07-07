package com.example.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageResource {

    @GetMapping("/image")
    public ResponseEntity<String> getImage() {
        return ResponseEntity.ok("Hello world.");
    }
}
