package com.example.demo.com.model;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FluentMybatis
public class User implements IEntity {
    @TableId(value = "id")
    private  Integer id;
    @NotNull
    private String username;
    private Integer sex;
    private Integer status;

}
