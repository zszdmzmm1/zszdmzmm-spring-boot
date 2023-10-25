package com.auefly.sb05redis.controller;

import com.auefly.sb05redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRedisController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Object> objectRedisTemplate;

    @GetMapping("hello-redis")
    public String helloRedis() {
        Long count = stringRedisTemplate.opsForValue().increment("count");
        return "count=" + count;
    }

    @GetMapping("get-object2redis")
    public User getObjectToRedis() {
        User user = new User("John", "admin");
        objectRedisTemplate.opsForValue().set("user", user);
        return (User) objectRedisTemplate.opsForValue().get("user");
    }

}
