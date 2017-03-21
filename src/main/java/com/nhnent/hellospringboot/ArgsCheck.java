package com.nhnent.hellospringboot;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ArgsCheck {
    
    private static final Logger logger = LoggerFactory.getLogger(ArgsCheck.class);
    
    @Autowired
    public ArgsCheck(ApplicationArguments args) {
        
        Set<String> argsList = args.getOptionNames();
        
        Iterator<String> iter = argsList.iterator();
        
        logger.info("ArgsCheck");
        while (iter.hasNext()) {
            
            String paramName = iter.next();
            List<String> valueList = args.getOptionValues(paramName);
            
            for (String value : valueList) {

                logger.info("[" + paramName + "] " + value);
            }
            
        }
    }

}