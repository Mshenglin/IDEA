package com.xu.msl.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //设置字符集
        request.setCharacterEncoding("utf-8");
     //获取页面的参数
        String username=request.getParameter("user");
        String password=request.getParameter("password");
        String checkCode=request.getParameter("yzm");
        System.out.println(username+password+checkCode);
        //获得session对象
         HttpSession session=request.getSession();
         //获取session中的验证码信息
        String checkCode_session =(String) session.getAttribute("checkCode_sission");
        //删除session储存的验证码
        session.removeAttribute("checkCode_sission");
        System.out.println(checkCode_session);
        //验证码正确
        if(checkCode!=null &&checkCode.equalsIgnoreCase(checkCode_session) )
        {
            //用户的账户和密码的判断
            if("zhangsan".equals(username)&&"123".equals(password))
            {
            session.setAttribute("user",username);
            request.setAttribute("user",username);
            response.sendRedirect(request.getContextPath()+"/success.jsp");}
            else {
                //用户密码不正确
                request.setAttribute("login_error","用户名密码错误");
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }
        else{
            request.setAttribute("login_error","验证码密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
