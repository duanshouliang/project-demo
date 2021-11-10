package com.tuen.redis.sample.service.impl;

import com.alibaba.fastjson.JSON;
import com.tuen.redis.sample.model.User;
import com.tuen.redis.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static Map<Integer, User> userMap = new HashMap<>();
    static {
        userMap.put(1, new User(1, "肖战", 10));
        userMap.put(2, new User(2, "王一博", 20));
        userMap.put(3, new User(3, "杨紫", 30));
    }

    //@CachePut,根据请求参数对七结果进行缓存，每次都会触发真实方法的调用
    @CachePut(value = "user", key = "#user.id")
    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        LOGGER.info("执行save， 存储内容为： {}", JSON.toJSONString(user));
        return user;
    }

    /**
     * CacheEvict 根据条件对缓存进行清空
     * allEntries: 是否清空所有的缓存，默认为false， True-方法调用之后将立即清空所有的缓存
     * beforeInvocation： 是否在方法执行前清空缓存，默认为false
     */
    @CacheEvict(value = "user", key = "#id", allEntries = false, beforeInvocation = false)
    @Override
    public void delete(Integer id) {
        LOGGER.info("删除前的内容：{}", JSON.toJSONString(userMap));

        userMap.remove(id);
        LOGGER.info("执行delete， 删除成功， 删除后的内容：{}", JSON.toJSONString(userMap));
    }

    /**
     * 根据请求参数对其结果进行缓存
     * key： 缓存的 Key，可以为空，如果指定要按照 SPEL 表达式编写，如果不指定，则按照方法的所有参数进行组合。与value以前拼装出最终的键
     * value：缓存的名称，必须指定至少一个（如 @Cacheable (value='user')或者 @Cacheable(value={'user1','user2'})）
     * Condition：缓存的条件，可以为空，使用 SPEL 编写，返回 true 或者 false，只有为 true 才进行缓存。
     *
     * @param id
     * @return
     */
    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Integer id) {
        LOGGER.info("进入get方法，当前获取对象：{}", userMap.get(id)==null?null:userMap.get(id).toString());
        return userMap.get(id);
    }
}
