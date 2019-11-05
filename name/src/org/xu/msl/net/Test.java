package org.xu.msl.net;


import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test<inteAddress> {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inte = null;
        InetAddress in = null;
        inte = InetAddress.getByName("www.mldnjava.com");
        in = InetAddress.getLocalHost();
        System.out.println("本机的地址" + in.getHostAddress());
        System.out.println("mldnjava" + inte.getHostAddress());


    }
 }

