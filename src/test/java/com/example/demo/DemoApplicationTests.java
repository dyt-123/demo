package com.example.demo;

import com.example.demo.com.mapper.UserMapper;
import com.example.demo.com.model.User;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;
import java.util.stream.Stream;


@SpringBootTest
@Log4j2
class DemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSet() {
        redisTemplate.boundValueOps("name").set("asdads");
    }

    @Test
    public void testGet() {
        Object name = redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }

    @Test
    public void test() {
        log.info("测试");
        User user = null;
        user = Optional.ofNullable(user).orElse(createUser());
        //user = Optional.ofNullable(user).orElseGet(() -> createUser());
        System.out.println(user);

    }

    public User createUser() {
        User user = new User();
        user.setUsername("zhangsan");
        return user;
    }
    @Test
    public void getUserTest() {
        User user = new User();
        user.setSex(1);
        user.setUsername("###");
        System.out.println(user);
    }


    @Test
    public void insert() {
        Stream.of("apple","banana","orange","waltermaleon","grape")
                .map(String::length) //转成单词的长度 int
                .forEach(System.out::println); //输出
        Stream.of("a-b-c-d","e-f-i-g-h")
                .flatMap(e->Stream.of(e.split("-")))
                .forEach(System.out::println);

    }
}
