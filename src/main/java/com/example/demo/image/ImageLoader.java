package com.example.demo.image;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class ImageLoader {

    private final Logger logger = Logger.getLogger("ImageLoader");

    public byte[] load(String path, String name) {
        logger.log(Level.INFO, "load {0}/{1}", List.of(path, name).toArray());
        return null;
    }
}
