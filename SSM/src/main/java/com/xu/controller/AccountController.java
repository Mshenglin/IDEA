package com.xu.controller;

import com.xu.domain.Account;
import com.xu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Dell
 * web层
 */
@Controller
@RequestMapping("/account")
public class  AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String FindAll(Model model){
        System.out.println("表现层：查询所有账户");
        List<Account> all = accountService.findAll();
        //调用service方法
        for (Account a:all
        ) {

            System.out.println("comtroller中"+a);
        }
        return "list";
    }
}
