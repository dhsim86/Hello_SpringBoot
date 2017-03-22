package com.nhnent.hellospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {
    
    private static Logger logger = LoggerFactory.getLogger(Receiver.class);
    
    @KafkaListener(topics = "helloworld.t")
    public void receiveMessage(String message) {
        
        logger.info("received message='{}'", message);
    }
}
