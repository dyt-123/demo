package com.example.demo.com.vo;

import cn.org.atool.fluent.mybatis.annotation.TableId;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @ClassName : UserVo
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-26
 */
@Data
public class UserVo {

    @ExcelProperty("姓名")
    private String username;

    private Integer sex;

    private Integer status;
}
