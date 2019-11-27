package cn.itcast.reflct;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
  不改变该类的任何代码前提下，可以帮助我们创建类的任意类的对象，并执行其中的任意方法
 */
public class ReflectDemo4 {
/*
    加载配置文件
 */
public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
    //1.1创捷Properies对象
    Properties properties=new Properties();
    //1.2.1获取class目录下的配置文件
    ClassLoader classLoader = ReflectDemo4.class.getClassLoader();//类加载
    InputStream is = classLoader.getResourceAsStream("pro.properties");
    properties.load(is);
    //2.获取配置文件定义的数据
    String className=properties.getProperty("className");
    String methodName=properties.getProperty("methodName");
    //加载该类到内存
    Class cls=Class.forName(className);
    //创建对象
    Object o = cls.newInstance();
    //获取方法对象
    Method method = cls.getMethod(methodName);
    //执行方法
    method.invoke(o);
}

}
