package com.nhnent.hellospringboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.nhnent.hellospringboot.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
    
    @Override
    public User findByNameNoCache(String name) {
        slowQuery(2000);
        
        return new User(0, name + "@gmail.com", name);
    }
    
    @Override
    @Cacheable(value="findMemberCache", key="#name")
    public User findByNameCache(String name) {
        slowQuery(2000);
        return new User(0, name + "@gmail.com", name);
    }
    
    @Override
    @CacheEvict(value="findMemberCache", key="#name")
    public void refresh(String name) {
        logger.info(name + " cache clear.");
    }
    
    private void slowQuery(long seconds) {
        try {
            Thread.sleep(seconds);
        }
        catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
