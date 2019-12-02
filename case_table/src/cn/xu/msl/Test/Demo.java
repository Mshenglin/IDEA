package cn.xu.msl.Test;

import org.omg.PortableInterceptor.INACTIVE;

public class Demo {
    public static void main(String[] args) {

        Integer s = 7;
        Integer a = 7;
        Integer c = Integer.valueOf(7);
        Integer z = new Integer(7);
        Integer a1 = 200;
        Integer s1 = 200;
        System.out.println(s == a);//true
        System.out.println(s == c);//t
        System.out.println(s == z );//t
        System.out.println(a1 == s1);//f
    }
}
