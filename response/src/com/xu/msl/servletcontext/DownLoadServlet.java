package com.xu.msl.servletcontext;

import com.xu.msl.untils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

@WebServlet("/download")
public class DownLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String str =  request.getParameter("filename");
        System.out.println(str);
        //2.使用字节输入流加载文件到内存
        //2.1找到文件的服务器路径
        ServletContext servletcontext= this.getServletContext();
        String realPath = servletcontext.getRealPath("/img/" + str);
        System.out.println(realPath);
        //2.2使用字节流关联
        FileInputStream fis=new FileInputStream(realPath);
        //3.设置response的响应头类型：content-type
        String mimeType = servletcontext.getMimeType(str);//获得文件的mime类型
        System.out.println(mimeType);
        response.setHeader("content-type",mimeType);
        //解决中文问题
        //获得user-agent的请求头
        String agent=request.getHeader("user-agent");
        System.out.println(agent);
        //使用工具类编码文件名
        String fileName = DownLoadUtils.getFileName(agent, str);
        response.setHeader("content-disposition","attachment;filename="+fileName);
        //将输入流的数据写入输入流中
        ServletOutputStream sos=response.getOutputStream();
        byte[] buff=new byte[11024*8];
        int len=0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();
    }
}
