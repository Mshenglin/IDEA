package cn.xu.msl.web.servlet;

import cn.xu.msl.domain.User;
import cn.xu.msl.service.UserService;
import cn.xu.msl.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //4.验证码的校验
        //利用session获取验证码
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        HttpSession session = request.getSession();
        //确保验证码错误的信息
        session.removeAttribute("CHECKCODE_SERVER");
        //获取页面的信息的验证码信息
        String verifycode = request.getParameter("verifycode");
        if (!verifycode.equalsIgnoreCase(checkcode_server))
        {
            //验证码不正确
            //跳转到提示页面
            request.setAttribute("mag", "验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //5.调用Service查询
        UserService service= new UserServiceImpl();
        User loginUser=service.login(user);
        //6.判断是否登录成功
        if (loginUser!=null)
        {
            //将用户的信息存储在Session
            session.setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        else{
            request.setAttribute("mag","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
