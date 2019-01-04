package com.lxy.transaction.dao;

/**
 * 转账dao接口
 */
public interface AccountDao {
    void inMoney(String in, Double money);

    void outMoney(String out, Double money);
}
