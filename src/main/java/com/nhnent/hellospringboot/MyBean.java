package com.nhnent.hellospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableCaching
public class MyBean {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MyBean(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        
    }
    
    
}
