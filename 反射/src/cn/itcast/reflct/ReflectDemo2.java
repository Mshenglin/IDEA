package cn.itcast.reflct;

import java.lang.reflect.Field;

/**
 * 通过反射获取成员变量们，构造方法们
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //获取person的Class对象
        Class PersonClass=Person.class;
        //1.获取成员变量,访问修饰符为public的变量
        Field[] field=PersonClass.getFields();
        for (Field f:field
             ) {
//            System.out.println(f);
        }
        System.out.println("--------");

        /**
         *  2.获取所有的成员变量，不看访问修饰符
         */
        Field[] fields=PersonClass.getDeclaredFields();
        for (Field f:fields
        ) {
//            System.out.println(f);
        }
        //得到指定的成员变量
        Field a= PersonClass.getField("a");
        Person person= new Person();
        a.set(person,"张三");//给对象赋值
        Object value = a.get(person);//得到person的a变量的值
        System.out.println(value);
        Field a1= PersonClass.getDeclaredField("d");
        //使用不是public修饰符的安全检查，使用暴力反射
        a1.setAccessible(true);
       a1.set(person,"lisi");
        Object value1= a1.get(person);
        System.out.println(value1);
    }

}
