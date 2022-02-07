package com.tuen.redis.sample.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtils.class);

    private static final byte[] UN_LOCK = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end".getBytes(StandardCharsets.UTF_8);

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    public Boolean tryLock(String key, String requestId, long seconds) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection ->
                connection.set(key.getBytes(StandardCharsets.UTF_8),
                        requestId.getBytes(StandardCharsets.UTF_8),
                        Expiration.from(seconds, TimeUnit.SECONDS),
                        RedisCommands.SetOption.SET_IF_ABSENT
                ));
    }

    public Boolean unlock(String key, String requestId) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection ->
                connection.eval(UN_LOCK, ReturnType.BOOLEAN,
                        1,
                        key.getBytes(StandardCharsets.UTF_8),
                        requestId.getBytes(StandardCharsets.UTF_8)
                ));
    }

    public <T> T get(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void set(String key, Serializable val) {
        redisTemplate.opsForValue().set(key, val);
    }
    public void set(String key, Serializable val, long expire, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, val, expire, timeUnit);
    }

    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public Boolean exist(String key) {
        return redisTemplate.hasKey(key);
    }


    public static String downCover(String targetId, String type) {
        String cover = "";
        String targetIdNew = "000" + targetId;
        String targetPath = "/" + type + "/" + targetIdNew.substring(targetIdNew.length() - 3);
        String target = targetId + "-1000x1000.jpg";
        cover = targetPath + "/" + target;
        return cover;
    }

    public static void main(String[] args) {
        System.out.println(downCover("197587286", "music"));
        System.out.println(downCover("24020181", "album"));
        System.out.println(downCover("24212014", "album"));
    }
}
