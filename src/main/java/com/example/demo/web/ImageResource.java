package com.example.demo.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.image.ImageLoader;

@RestController
public class ImageResource {

    private final Logger logger = Logger.getLogger("ImageResourceLogger");
    private final ImageLoader imageLoader;
    private final CacheManager cacheManager;

    public ImageResource(ImageLoader imageLoader, CacheManager cacheManager) {
        this.imageLoader = imageLoader;
        this.cacheManager = cacheManager;
    }

    @GetMapping(value = "/image/{imageId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(
        @PathVariable String imageId
    ) {
        logger.log(Level.INFO, "imageId={0}", imageId);

        var image = imageLoader.load("/var/tmp/cess", imageId);
        return ResponseEntity.ok(image);
    }
}
