package com.nhnent.hellospringboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhnent.hellospringboot.dao.HelloDao;
import com.nhnent.hellospringboot.entity.Hello;

@RestController
public class HelloRestController {

    @Autowired
    private HelloDao helloDao;
    
    @Value("${hello_spring_boot.print.hello}")
    private String hello_string;
    
    @RequestMapping("/")
    public String index() {
        
        return hello_string;
    }
    
    @RequestMapping("/add")
    public Hello add(Hello hello) {
        
        Hello helloData = helloDao.save(hello);
        
        return helloData;
    }
    
    @RequestMapping("/list")
    public List<Hello> list(Model model) {
        
        List<Hello> helloList = helloDao.findAll();
        
        return helloList;
    }
    /*
    @RequestMapping(path="/session-test", produces="text/plain")
    public String sessionTest(HttpSession session) {
        
        session.setAttribute("test", "hello");
        return (String)session.getAttribute("test");
    }*/
}
