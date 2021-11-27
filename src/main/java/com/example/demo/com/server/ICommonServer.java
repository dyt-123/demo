package com.example.demo.com.server;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @ClassName : commonServer
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-27
 */
public interface ICommonServer {
    /**
     * 导出excel
     * @param response
     * @param <T>
     */
    public <T> void export(List<T> list,Class<T> clazz, String title, HttpServletResponse response);
}
