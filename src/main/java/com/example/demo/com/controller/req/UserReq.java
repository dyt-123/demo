package com.example.demo.com.controller.req;

import cn.org.atool.fluent.mybatis.annotation.TableId;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @ClassName : UserReq
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-25
 */
@Data
public class UserReq {

    private String username;
    private Integer sex;
    private Integer status;
}
