package com.example.demo.com.config;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : SingleConfig
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-16
 */

@Configuration
public class SingleConfig {
    // 定义fluent mybatis的MapperFactory
    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }
}
