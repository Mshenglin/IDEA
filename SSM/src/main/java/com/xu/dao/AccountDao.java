package com.xu.dao;

import com.xu.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dell
 */
@Repository
public interface AccountDao {
    /**
     * 保存账户的方法
     */

    @Insert("insert into account (name,money) values (#{name},#{money})")
    void saveAccount(Account account);
    /**
     * 查询所有的方法
     */
    @Select("select * from account")
    List<Account> findAll();
}
