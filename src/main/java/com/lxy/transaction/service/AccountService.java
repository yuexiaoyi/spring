package com.lxy.transaction.service;

/**
 * 转账service接口
 */
public interface AccountService {
    /**
     * 转出账户：out
     * 转入账户: in
     * 金额：money
     * @param out
     * @param in
     * @param money
     */
    void transfer(String out, String in, Double money);
}
