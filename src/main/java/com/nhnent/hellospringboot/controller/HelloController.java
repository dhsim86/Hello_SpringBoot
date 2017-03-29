package com.nhnent.hellospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhnent.hellospringboot.Sender;
import com.nhnent.hellospringboot.dao.UserRepository;
import com.nhnent.hellospringboot.entity.User;

@Controller
@EnableCaching
public class HelloController {
    
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private Sender sender;
    
    @RequestMapping(path = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String index(Model model) {
        
       model.addAttribute("name", "Spring Blog");
       return "hello";
    }
    
    @RequestMapping("/kakfaTest/{value}")
    public void kafkaTest(@PathVariable String value) {
        
        sender.sendMessage("helloworld.t", value);
        
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
