package com.lxy.transaction.dao.impl;

import com.lxy.transaction.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * dao实现类
 */
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        jdbcTemplate.update(sql,money,in);
    }

    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        jdbcTemplate.update(sql,money,out);
    }
}
