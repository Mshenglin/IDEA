package com.xu.msl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 向页面输出字符
 */
@WebServlet("/responsedemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo3....");
        //获取流之前，设置流的默认编码：ISO-8891 设置为GBK
//        response.setCharacterEncoding("GBk");
        response.setHeader("content-type","text/html;charset=utf-8");
        //简单的形式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.write("<h1>你好hehe</h1>");
    }
}
