package com.nhnent.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhnent.hellospringboot.dao.HelloDao;
import com.nhnent.hellospringboot.entity.Hello;

@RestController
public class HelloRestController {

    @Autowired
    private HelloDao helloDao;
    
    @RequestMapping("/")
    public String index() {
        
        return "Hello World!";
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
}
