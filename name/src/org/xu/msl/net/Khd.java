package org.xu.msl.net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Khd {
    public static void main(String[] args) throws IOException {
        Socket s=new Socket("127.0.0.1", 8000);
//        Scanner sc=new Scanner(s.getInputStream());
//        String str=sc.nextLine();
        Scanner scanner= new Scanner(System.in);
//        System.out.println("服务端说"+str);
        PrintWriter inp=new PrintWriter(s.getOutputStream(),true);
        inp.println("hi");
        Scanner sc=new Scanner(s.getInputStream());

        while (true){
            String str=sc.nextLine();
            System.out.println("服务器端说"+str);
            inp.println(scanner.next());
        }
    }
}
