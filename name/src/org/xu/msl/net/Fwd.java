package org.xu.msl.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Fwd{
    public static void main(String[] args) throws IOException {
        ServerSocket si=new ServerSocket(8000);//实例化一个服务端对象
        System.out.println("服务器等待连接");
        Socket kh = si.accept();//
        System.out.println("用户已连接");
        OutputStream s = kh.getOutputStream();//创建网络输出流
        PrintWriter  out=new PrintWriter(s,true);
        out.println("Hello");
        Scanner sc= new Scanner(kh.getInputStream());
       String m= sc.nextLine();
        System.out.println("客户端说"+m);
        Scanner scanner=new Scanner(System.in);
        while(true){
            out.println(scanner.next());
            String n=sc.nextLine();
            System.out.println("客户端说"+n);
        }
    }
}
