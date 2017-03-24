package com.nhnent.hellospringboot.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.nhnent.hellospringboot.entity.User;

@Service
public class UserService {
    
    private Map<String, User> users;
    
    @PostConstruct
    private void loadUser() {
        
        users = new HashMap<>();
        
        users.put("1",  new User(0, "dhsim86@example.com", "Dongho Sim"));
        users.put("2",  new User(1, "dhsim86@naver.com", "Dongho Sim - Naver"));
    }
    
    public User findById(String id) {
        return users.get(id);
    }
}
