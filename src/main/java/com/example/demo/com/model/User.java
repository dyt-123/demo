package com.example.demo.com.model;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.IEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FluentMybatis
public class User implements IEntity {
    @TableId(value = "id", auto = true)
    private  Integer id;
    private String username;
    private Integer sex;
    private Integer status;

}
