package com.xu.msl;

public class ObjectDemo {
    int id;
    String name;

    public void say(ObjectDemo o) {
        o.name="张三";
    }

    public ObjectDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        ObjectDemo objectDemo=new ObjectDemo(3,"李四");
        objectDemo.say(objectDemo);
        System.out.println("我的名字是" + objectDemo.name);
    }
};


