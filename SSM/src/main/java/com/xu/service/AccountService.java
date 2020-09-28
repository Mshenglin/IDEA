package com.xu.service;

import com.xu.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 保存账户的方法
     */
    public void saveAccount(Account account);
    /**
     * 查询所有的方法
     */
    public List<Account> findAll();
}

