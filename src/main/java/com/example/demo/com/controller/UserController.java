package com.example.demo.com.controller;

import cn.hutool.extra.tokenizer.Result;
import cn.org.atool.fluent.mybatis.If;
import cn.org.atool.fluent.mybatis.model.TagPagedList;
import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ejlchina.searcher.MapSearcher;
import com.ejlchina.searcher.SearchResult;
import com.ejlchina.searcher.util.MapUtils;
import com.ejlchina.searcher.util.StringUtils;
import com.example.demo.com.common.*;
import com.example.demo.com.controller.req.UserReq;
import com.example.demo.com.mapper.UserMapper;
import com.example.demo.com.model.User;
import com.example.demo.com.model.UserTest;
import com.example.demo.com.server.CommonServerImpl;
import com.example.demo.com.server.ICommonServer;
import com.example.demo.com.vo.UserVo;
import com.example.demo.com.wrapper.UserQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
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
@Log4j2
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MapSearcher mapSearcher;

    @Autowired(required=true)
    private ICommonServer commonServer;

    @GetMapping("/page")
    public ResponseData<?> page(UserReq req) {
        UserQuery userQuery = new UserQuery();
        userQuery
                .where.sex().eq(req.getSex(),If::notNull)
                .and.username().like(req.getUsername(),If::notNull)
                .and.status().eq(req.getStatus(),If::notNull).end();
        List<User> users = userMapper.listEntity(userQuery);
        return ResponseData.success(users);
    }

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

    @GetMapping("/list")
    public SearchResult<Map<String, Object>> index(HttpServletRequest request) {
        // 这里咱们只写一行代码
        return mapSearcher.search(UserTest.class, MapUtils.flat(request.getParameterMap()));
    }


    @GetMapping ("/getTree")
    public ResponseData<?> getTree() {
        ArrayList<User> objects = new ArrayList<>();
        objects.add(new User(1,"dyt",1,1));
        objects.add(new User(2,"dyt",2,2));
        objects.add(new User(3,"dyt",3,3));
        JSONArray objects1 = List2Tree.listToTree(JSONArray.parseArray(JSON.toJSONString(objects)), "id", "username", "id", "children", null, "cId", "cName");
        System.out.println(objects1);
        return ResponseData.success(objects);
    }

    @ApiOperation("批量删除")
    @DeleteMapping("/{ids}")
    public ResponseData<?> delete(@PathVariable List<Long> ids) {
        if (ids == null || ids.size() == 0) {
            return ResponseData.error(ErrorStatusEnum.ID_NOT_EXIST);
        }
        userMapper.deleteByIds(ids);
        return ResponseData.success();
    }

    @ApiOperation("添加")
    @PostMapping("")
    public ResponseData<?> add(@RequestBody User req) {
        userMapper.saveOrUpdate(req);
        return ResponseData.success();
    }

    @ApiOperation("修改")
    @PutMapping("/{id}")
    public ResponseData<?> update(@PathVariable String id, @RequestBody UserReq req) {
        User mapperById = userMapper.findById(id);
        if (mapperById == null) {
            return ResponseData.error(ErrorStatusEnum.ID_NOT_EXIST);
        }
        BeanUtils.copyProperties(req, mapperById);
        userMapper.saveOrUpdate(mapperById);
        return ResponseData.success();
    }

    @RequestMapping("/downloadTemplate")
    @ApiOperation(value = "导入Excel模板", notes = "导入Excel")
    public void downloadTemplate(HttpServletResponse response) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("static/dy_user.xlsx");
        response.setContentType("application/octet-stream; charset=UTF-8");
        InputStream inputStream = classPathResource.getInputStream();
        FileUtils.setAttachmentResponseHeader(response, "用户信息模板.xlsx");
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @ApiOperation(value = "导入Excel", notes = "导入Excel")
    @PostMapping("/import")
    public ResponseData<?> importInfo(@RequestParam("file") MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                return ResponseData.error("excel文件为空！");
            }
            InputStream inputStream = file.getInputStream();
            List<User> entitylist = new ArrayList<User>();
            List<UserVo> vos = EasyExcel.read(inputStream)
                    .head(UserVo.class)
                    // 设置sheet,默认读取第一个
                    .sheet()
                    // 设置标题所在行数
                    .headRowNumber(2)
                    .doReadSync();
            if(null == vos || vos.size() ==0 ){
                return ResponseData.error("导入excel数据为空！" );
            }
            for (UserVo vo:vos) {
                if (StringUtils.isBlank(vo.getUsername())) {
                    return ResponseData.error("导入excel数据失败！" + vo.getUsername());
                }
                User user = new User();
                BeanUtils.copyProperties(vo, user);
                entitylist.add(user);
                //userMapper.insert(user);
            }
            userMapper.save(entitylist);

            return ResponseData.success();
        } catch (Exception e) {
            log.error("导入excel数据失败！", e);
        }
        return ResponseData.error("导入excel数据失败！");
    }

    @PostMapping("/export")
    @ApiOperation(value = "导出Excel", notes = "导出Excel")
    public void export(HttpServletResponse response, UserReq req) {
        try {
            UserQuery userQuery = new UserQuery();
            userQuery
                    .where.sex().eq(req.getSex(),If::notNull)
                    .and.username().like(req.getUsername(),If::notNull)
                    .and.status().eq(req.getStatus(),If::notNull).end();
            List<User> users = userMapper.listEntity(userQuery);
            List<UserReq> userReqs=new ArrayList<>();
            for ( User re: users) {
                UserReq userReq = new UserReq();
                BeanUtils.copyProperties(re,userReq);
                userReqs.add(userReq);
            }
            commonServer.export(userReqs, UserReq.class,"用户信息导出",response);
        }catch (Exception e){
            throw new BusinessException("下载失败" + e.getMessage());
        }
    }
}