package com.xu.msl.session;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 向页面输出字节流
 */
@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int width=100;
    int height=50;
        //创建一个对象，在内存中图片（验证码对象）
        BufferedImage img=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //美化图片
        //2.1填充背景色
        Graphics g=img.getGraphics();//画笔对象
        g.setColor(Color.PINK);//设置画笔的颜色
//        g.fillRect(0,0,width,height);
        //2.2画边框
//        g.setColor(Color.BLUE);
//        g.fillRect(0,0,width-1,height-1);

        String string="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran=new Random();
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            int index=ran.nextInt(string.length());
            char ch=string.charAt(index);
            sb.append(ch);
            //2.3,写验证码
            g.drawString(String.valueOf(ch),width/5*i,height/2);
        }
        //将字母存入session中
        String checkCode_sission=sb.toString();
        HttpSession session = request.getSession();
        session.setAttribute("checkCode_sission",checkCode_sission);
        //2.4画干扰线
        //随机生成坐标
        g.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(width);
            int y2=ran.nextInt(height);

            g.drawLine(x1,x2,y1,y2);
        }

        //将图片输出到页面
        ImageIO.write(img,"jpg",response.getOutputStream());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
