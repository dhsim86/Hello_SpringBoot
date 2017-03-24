package com.nhnent.hellospringboot.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

@Component
@Path("/helloworld")
public class HelloWorldEndPoint {
    
    @GET
    @Path("/message")
    public String sayHelloWorld() {
        return "Hello World!";
    }
}