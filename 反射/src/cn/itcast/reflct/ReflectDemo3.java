package cn.itcast.reflct;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.sql.SQLOutput;

/**
 * 获取构造方法
 *
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        /**
         * 通过反射，得到类对象
         */
        Class personClass = Person.class;
        /**
         * 得到构造方法
         */
       Constructor  constructor=personClass.getConstructor(String.class,int.class);
        /**
         * 通过构造方法创建对象
         */
        Object person= constructor.newInstance("马生林",23);
        System.out.println(person);

        Object constructor1 = personClass.newInstance();
        System.out.println(constructor1 );

    }
    @Test
    public  void add(){

    }
}
