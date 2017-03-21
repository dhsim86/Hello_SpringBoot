package com.nhnent.hellospringboot.dao;

import com.nhnent.hellospringboot.entity.User;

public interface UserRepository {

    User findByNameNoCache(String name);
    User findByNameCache(String name);
    void refresh(String name);
}
