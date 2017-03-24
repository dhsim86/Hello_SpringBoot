package com.nhnent.hellospringboot.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nhnent.hellospringboot.entity.User;
import com.nhnent.hellospringboot.service.UserService;

@Component
@Path("/users")
public class HelloJerseyEndPoint {
    
    @Autowired
    private UserService userService;
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getEventVersion1(@PathParam("id") String id) {
        
        return userService.findById(id);
    }
}
