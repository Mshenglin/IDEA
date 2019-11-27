package cn.itcast.reflct;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         *
         * 获得Class对象的方式：
         * 1.Class.forName("全类名")：将字节码文件加载进内存返回Class对象
         * 2.类名.class: 通过类名的属性class获取
         *
         */
       Class cls= Class.forName("cn.itcast.reflct.Person");
       System.out.println(cls);
       //2.类名.class
       Class cls2=Person.class;
       System.out.println(cls2);
       //3.对象.getClass()
        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);


    }
}
