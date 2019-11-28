package com.xu.msl.servletcontext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContextDemo1")
public class servletcontext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * ServletContext的两种获取方式
         *  1.通过request对象获取
         *      request.getServletContext()
         *  2.通过HttpServlet获取
         *  this.getServletContext()
         */
        request.getServletContext();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
