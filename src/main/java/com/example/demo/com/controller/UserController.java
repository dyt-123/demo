package com.example.demo.com.controller;

import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.example.demo.com.mapper.UserMapper;
import com.example.demo.com.model.User;
import com.example.demo.com.model.UserTest;
import com.example.demo.com.wrapper.UserQuery;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName : UserController
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-16
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户操作api")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MapSearcher mapSearcher;

    @GetMapping("/getByIdOne")
    public User getByIdOne() {
        UserQuery userQuery = new UserQuery();
        userQuery.where.id().eq(1).end();
        return userMapper.findOne(userQuery);
    }
    @GetMapping("/getByIdOne1")
    public User getByIdOne1() {
        return userMapper.findById("1");
    }
    @GetMapping("/index")
    public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
        // 这里咱们只写一行代码
        return mapSearcher.search(UserTest.class, MapUtils.flat(request.getParameterMap()));
    }
}