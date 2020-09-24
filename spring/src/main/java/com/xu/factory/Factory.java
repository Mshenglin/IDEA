package com.xu.factory;

import org.apache.naming.factory.BeanFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * javabean工厂模式
 *
 */
public class Factory {
    //定义一个Properties对象
    private static Properties properties;
    //使用静态代码块为properties对象赋值
    static {
        //实例化对象
        properties=new Properties();
        //获取properties对象
        InputStream in =  BeanFactory.class.getClassLoader().getResourceAsStream("Bean.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean的名称获取Bean对象
     * @param beanName
     * @return
     */
        public Object getBean(String beanName){
            Object bean=null;
            try {
                //根据配置文件获取对象
                String beanPath=properties.getProperty(beanName);
                bean=Class.forName(beanPath).newInstance();
            }catch (Exception e){
            }
            return bean;
        }

}
