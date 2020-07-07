package com.example.demo.image;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class ImageLoader {

    private final Logger logger = Logger.getLogger("ImageLoader");

    public byte[] load(String path, String id) {
        var imagePath = path + "/" + "img" + id + ".png";
        logger.log(Level.INFO, "load {0}", imagePath);

        try(
            var is = new FileInputStream(imagePath);
        ) {
            return is.readAllBytes();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.toString());
        }

        return null;
    }
}
