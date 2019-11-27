package cn.itcast.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Pro(className = "cn.itcast.annotation.Demo01",methodName = "eat")
public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    //解析注解
        //1.1获得该类的字节码文件对象
        Class<Demo> demo = Demo.class;
        //获取上面的注解对象
        //其实就是在内存中生成了一个该注解的子类实现对象
        Pro an = demo.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获得返回值
        String className=an.className();
        String methodName=an.methodName();
        System.out.println(className);
        System.out.println(methodName );
       Class cla = Class.forName("cn.itcast.annotation.Demo01");
        Object d = cla.newInstance();
       Method eat=cla.getMethod(methodName);
       eat.invoke(d);

    }
}
