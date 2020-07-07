package com.example.demo.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageResource {

    final Logger logger = Logger.getLogger("ImageResourceLogger");

    @GetMapping("/image/{imageId}")
    public ResponseEntity<String> getImage(
        @PathVariable String imageId
    ) {
        logger.log(Level.INFO, "imageId={0}", imageId);
        return ResponseEntity.ok("Hello world.");
    }
}
