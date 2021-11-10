package com.tuen.redis.sample.service;

import com.tuen.redis.sample.model.User;

public interface UserService {
    User save(User user);

    void delete(Integer id);

    User get(Integer id);
}
