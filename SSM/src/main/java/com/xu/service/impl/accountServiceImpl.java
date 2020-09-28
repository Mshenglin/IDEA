package com.xu.service.impl;

import com.xu.dao.AccountDao;
import com.xu.domain.Account;
import com.xu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountServiceImpl")
public class accountServiceImpl implements AccountService {
    @Autowired
     private AccountDao accountDao;
    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountDao.saveAccount(account);
    }

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return accountDao.findAll();
    }
}
