package org.xu.msl.xxxx;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Xxx {

//客户端

        public static void main(String[] args) throws UnknownHostException, IOException {
            Socket socket=new Socket("127.0.0.1",8000);
            Scanner sc=new Scanner(socket.getInputStream());//网络输入流
            String str=sc.nextLine();
            System.out.println("服务器端说："+str);
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
            pw.println("您好！");



        }


}
