package com.example.demo.image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ImageLoader {

    private final Logger logger = Logger.getLogger("ImageLoader");

    @Cacheable(cacheNames = "image")
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

    @CacheEvict(cacheNames = "image", allEntries = true)
	@Scheduled(cron = "0 * * * * *")
	public void cacheEvict() {
	    logger.log(Level.INFO, "caches evict. {0}", new Date());
	}
}
