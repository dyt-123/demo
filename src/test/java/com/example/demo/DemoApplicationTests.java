package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.com.common.List2Tree;
import com.example.demo.com.mapper.UserMapper;
import com.example.demo.com.model.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


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

    @Test
    public void testStream() {
        ArrayList<User> objects = new ArrayList<>();
        objects.add(new User(1,"dyt",1,1));
        objects.add(new User(2,"dyt",2,1));
        objects.add(new User(1,"dyt",1,1));
        //objects.stream().filter((e)-> e.getUsername().equals("dyt")).forEach(System.out::println);
        objects.stream().distinct().forEach(System.out::println);
        System.out.println("----1----");
        objects.stream().map(User::getSex).forEach(System.out::println);
        System.out.println("----2----");
        objects.stream().map(User::getSex).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----3----");
        objects.stream().sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).forEach(System.out::println);
        for (User o :
                objects) {
            System.out.println(o);
        }
    }
    @Test
    public void testOptional(){
        User dy = new User();
        User dyt = new User(1, "dyt", 1, 1);
        User user = Optional.of(dy).orElse(dyt);
        System.out.println(user);
    }

    @Test
    public void testListToTree(){
        boolean b = ObjectUtils.allNotNull(1);
        System.out.println(b);
    }

}
