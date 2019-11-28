package com.xu.msl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responsedemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo3....");
//        //重定向
//        //访问/responseDemo1，会自动跳转到/responseDemo2资源
//        //1.设置状态码
//        response.setStatus(302);
//        //2.设置响应头
//        response.setHeader("location","/re1sponsedemo1");

        //简单的重定向的方法
        System.out.println(request.getContextPath());
        response.sendRedirect("/responsedemo2");
    }
}
