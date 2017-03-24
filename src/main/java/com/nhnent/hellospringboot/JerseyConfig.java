package com.nhnent.hellospringboot;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnent.hellospringboot.controller.HelloJerseyEndPoint;
import com.nhnent.hellospringboot.controller.HelloWorldEndPoint;

@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    
    @Autowired
    public JerseyConfig(ObjectMapper objectMapper) {
        
        //packages("com.nhnent.hellospringboot");
        
        register(HelloJerseyEndPoint.class);
        register(HelloWorldEndPoint.class);
        register(new ObjectMapperContextResolver(objectMapper));
    }
    
    @Provider
    public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
        
        private final ObjectMapper objectMapper;
        
        public ObjectMapperContextResolver(ObjectMapper objectMapper) {
            this.objectMapper = objectMapper;
        }
        
        @Override
        public ObjectMapper getContext(Class<?> type) {
            
            return objectMapper;
        }
    }
}
