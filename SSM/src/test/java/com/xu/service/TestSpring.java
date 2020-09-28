package com.xu.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void findAll(){
     //加载配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
     //获取对象
    AccountService account= (AccountService) ac.getBean("accountServiceImpl");
     //调用方法
        account.findAll();
    }
}
