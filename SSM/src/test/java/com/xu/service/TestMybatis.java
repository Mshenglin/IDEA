package com.xu.service;

import com.xu.dao.AccountDao;
import com.xu.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class TestMybatis {
    @Test
    public void Test() throws Exception {
     //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSEssionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession session = factory.openSession();
        //获得代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list = dao.findAll();
        for (Account a:list
             ) {
            System.out.println(a);

        }
        //关闭资源
        session.close();
        resourceAsStream.close();;
    }
    @Test
    public void TestSave() throws Exception {
        Account account=new Account();
        account.setId(5);
        account.setName("huhu");
        account.setMoney(34.0);
        //加载配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSEssionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession对象
        SqlSession session = factory.openSession();
        //获得代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //向数据库存数据
       dao.saveAccount(account);
       session.commit();
        //关闭资源
        session.close();
        resourceAsStream.close();;
    }
}
