package com.example.demo.com.model;

import cn.org.atool.fluent.mybatis.base.IEntity;
import com.ejlchina.searcher.bean.SearchBean;
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
@SearchBean(tables="user u" ,autoMapTo="u")
public class UserTest implements IEntity {
    private  Integer id;
    private String username;
    private Integer sex;
    private Integer status;

}
