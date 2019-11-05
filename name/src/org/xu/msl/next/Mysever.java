package org.xu.msl.next;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Mysever {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket= new ServerSocket(9999);//向外提供一个端口号
            System.out.println("等待连接！");
            Socket server=serverSocket.accept();
            System.out.println("连接成功！");
            Scanner scanner=new Scanner(System.in);
//            PrintWriter writer=new PrintWriter(server.getOutputStream(),true);//获得网络输出流
//            writer.println("请问能帮您做什么？");
            while(true){
                PrintWriter writer=new PrintWriter(server.getOutputStream(),true);//获得网络输出流
                writer.println(scanner.next());
                Scanner scanner1=new Scanner(server.getInputStream());
                String string=scanner.nextLine();
                if (string != null) {
                    System.out.println("客户端说"+string);

                }
                           }

        } catch (IOException e) {
            e.printStackTrace();//
        }
    }
}
