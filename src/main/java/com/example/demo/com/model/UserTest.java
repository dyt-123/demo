package com.example.demo.com.model;

import cn.org.atool.fluent.mybatis.base.IEntity;
import com.ejlchina.searcher.bean.SearchBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


/**
 *
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SearchBean(tables="user u" ,autoMapTo="u")
public class UserTest implements IEntity {
    private  Integer id;
    @NotNull
    @Length(min = 6, max = 10)
    private String username;
    private Integer sex;
    private Integer status;

}
