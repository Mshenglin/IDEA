package org.xu.msl.next;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Several
{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
//        Scanner s1=new Scanner(socket.getInputStream());
//        String str=s1.nextLine();
//        System.out.println(str);
       Scanner scanner=new Scanner(System.in);
            while(true){
                Scanner s1=new Scanner(socket.getInputStream());
                String str=s1.nextLine();
                System.out.println(str);
                if(str!=null){
                PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
                printWriter.println(scanner.next());
                }
            }
    }
}
