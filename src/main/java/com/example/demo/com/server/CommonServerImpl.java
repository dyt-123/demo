package com.example.demo.com.server;

import com.alibaba.excel.EasyExcel;
import com.example.demo.com.common.BusinessException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName : CommonServerImpl
 * @Description : <b>  <b>
 * @Author : dyt
 * @Date: 2021-11-27
 */
@Service
public class CommonServerImpl implements ICommonServer{
    @Override
    public <T> void export(List<T> list, Class<T> clazz, String fileName, HttpServletResponse response) {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            EasyExcel.write(response.getOutputStream(), clazz).sheet(fileName).doWrite(list);
        } catch (Exception e) {
            throw new BusinessException("下载失败" + e.getMessage());
        }

    }
}
