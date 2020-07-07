package com.example.demo.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.image.ImageLoader;

@RestController
public class ImageResource {

    private final Logger logger = Logger.getLogger("ImageResourceLogger");
    private final ImageLoader imageLoader;

    public ImageResource(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @GetMapping("/image/{imageId}")
    public ResponseEntity<String> getImage(
        @PathVariable String imageId
    ) {
        logger.log(Level.INFO, "imageId={0}", imageId);

        final byte[] image = imageLoader.load("/var/tmp/cess", imageId);
        return ResponseEntity.ok("Hello world.");
    }
}
