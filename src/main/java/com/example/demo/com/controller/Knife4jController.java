package com.example.demo.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : Knife4jController
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-17
 */
@RestController
@RequestMapping("Knife4j")
@Api("/Knife4j")
public class Knife4jController {
    /**
     * Knife4j 测试接口问好
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    @ApiImplicitParam(name = "name", value = "名称", required = true)
    @ApiOperation(value = "公众号Java技术栈向你问好！")
    @GetMapping("/knife4j/hi")
    public ResponseEntity<String> hello(@RequestParam(value = "name") String name) {
        return ResponseEntity.ok("Hi:" + name);
    }

    /**
     * Knife4j 测试接口登录
     * 来源微信公众号：Java技术栈
     * 作者：栈长
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true)
    })
    @ApiOperation(value = "接口登录！")
    @PostMapping("/knife4j/login")
    public ResponseEntity<String> login(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "password") String password) {
        if (StringUtils.isNotBlank(username) && "javastack".equals(password)) {
            return ResponseEntity.ok("登录成功:" + username);
        }
        return ResponseEntity.ok("用户名或者密码有误:" + username);
    }
}
