package com.nhnent.hellospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhnent.hellospringboot.dao.UserRepository;
import com.nhnent.hellospringboot.entity.User;

@Controller
@EnableCaching
public class HelloController {
    
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping("/hello")
    public String index(Model model) {
        
       model.addAttribute("name", "Spring Blog");
       return "hello";
    }
    
    @GetMapping("/member/nocache/{name}")
    @ResponseBody
    public User getNoCacheMember(@PathVariable String name) {
        
        long start = System.currentTimeMillis();
        
        User user = userRepository.findByNameNoCache(name);
        
        long end = System.currentTimeMillis();
        
        logger.info(name + " NoCache time: " + Long.toString(end - start));
        
        return user;
    }
    
    
    @GetMapping("/member/cache/{name}")
    @ResponseBody
    public User getCacheMember(@PathVariable String name) {
        
        long start = System.currentTimeMillis();
        
        User user = userRepository.findByNameCache(name);
        
        long end = System.currentTimeMillis();
        
        logger.info(name + " Cache time: " + Long.toString(end - start));
        
        return user;
    }
    
    @GetMapping("/member/refresh/{name}")
    @ResponseBody
    public String refresh(@PathVariable String name) {
        
        userRepository.refresh(name);
        return "cache clear";
    }
}
