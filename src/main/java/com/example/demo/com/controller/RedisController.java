package com.example.demo.com.controller;

import com.example.demo.com.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName : RedisController
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-14
 */
@RestController
@RequestMapping("test")
//@Api(tags = "redis api")
public class RedisController {


    @GetMapping("/test")
//    @ApiOperation(value = "添加用户")
//    @ApiImplicitParam(name = "user",value = "用户实体类",dataType ="string")
    public String getTest(){
        return "name";
    }


    @GetMapping("/test2")
//    @ApiOperation(value = "测试")
//    @ApiImplicitParam(name = "name",value = "测试",dataType ="string")
    public User test( ){
        //User user = userMapper.selectById("1");
        return null;
    }

    @GetMapping("/test3")
//    @ApiOperation(value = "测试校验")
//    @ApiImplicitParam(name = "name",value = "测试",dataType ="user")
    public User test3( ){
        User user = new User();
        user.setSex(1);
        // user.setUsername("###");
        System.out.println(user);
        return user;
    }


    @GetMapping("/testInsert")
//    @ApiOperation(value = "测试校验")
    public void insert(){


    }

}
