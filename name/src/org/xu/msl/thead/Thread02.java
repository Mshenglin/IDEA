package org.xu.msl.thead;

import java.io.IOException;
import java.net.Socket;

public class Thread02 implements Runnable {
     int   acr=100;
     int   name;

    public Thread02(int n){
        this.name=n;
    }

    public void run() {
        for (int i =name ; i <65535 ; i+=acr) {
            try {
                Socket socket=new Socket("127.0.0.1",i);
                System.out.println(i);
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread=new Thread(new Thread02(i));
            thread.start();
        }


    }

}
