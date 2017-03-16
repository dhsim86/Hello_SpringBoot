package com.nhnent.hellospringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnent.hellospringboot.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer> {
    
}