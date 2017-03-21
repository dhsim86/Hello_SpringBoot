package com.nhnent.hellospringboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.CookieSerializer;
//import org.springframework.session.web.http.DefaultCookieSerializer;

//@Configuration
//@EnableRedisHttpSession
//@PropertySource("classpath:application.properties")
public class SessionConfig {
    /*
    @Value("${redis.host}")
    private String host;
    
    @Value("${redis.port}")
    private int port;
    
    @Value("${redis.database}")
    int database;
    

    @Bean
    public JedisConnectionFactory connectionFactory() {
        
        JedisConnectionFactory conn = new JedisConnectionFactory();
        
        conn.setHostName(host);
        conn.setPort(port);
        conn.setDatabase(database);
        conn.setUsePool(true);
        
        return conn;
    }
    
    @Bean
    public CookieSerializer cookieSerializer() {
        
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        
        return serializer;
    } */
}
