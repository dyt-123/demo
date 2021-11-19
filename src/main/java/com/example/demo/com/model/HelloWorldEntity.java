package com.example.demo.com.model;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * dyt
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FluentMybatis
public class HelloWorldEntity implements IEntity {
    @TableId(value = "id")
    private Long id;
    private String sayHello;

    private String yourName;

    private Date gmtCreated;

    private Date gmtModified;

    private Boolean isDeleted;

}
