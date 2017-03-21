package com.nhnent.hellospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRoutine implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyCommandLineRoutine.class);
    
    private final CacheManager cacheManager;
    
    public MyCommandLineRoutine(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
    
    public void run(String ... args) {
        
        logger.info("CommandLineRunner Do.");
        logger.info("Using cache manager: " + this.cacheManager.getClass().getName());
    }
}
