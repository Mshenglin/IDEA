package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Stack;

/**
 * 账户的业务层实现类
 *使用注解实现springIoc
 */
@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao ;

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void  saveAccount() {
        accountDao.saveAccount();
        Stack<Integer> stack = new Stack<>();
        System.out.println();
    }
}
