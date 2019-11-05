package org.xu.msl.xxxx;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Xxxxxxxx {
    //服务器端
        public static void main(String[] args) {
            try {
                ServerSocket ss=new ServerSocket(8000);
                System.out.println("等待连接。。。");
                Socket socket=ss.accept();//等待连接
                System.out.println("已连接第一位用户！");
                OutputStream os=socket.getOutputStream();//网络输出流
                PrintWriter pw=new PrintWriter(os,true);
                pw.println("hello");
                Scanner sc=new Scanner(socket.getInputStream());
                String s=sc.nextLine();
                System.out.println("客户端说："+s);




            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

        }
    }

}
