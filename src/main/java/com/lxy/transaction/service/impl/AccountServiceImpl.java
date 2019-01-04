package com.lxy.transaction.service.impl;

import com.lxy.transaction.dao.AccountDao;
import com.lxy.transaction.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

/**
 * service实现类
 * 编程式事务管理可以通过使用PlatformTransactionManager、TransactionTemplate
 * 声明式事务管理是通过AOP实现的
 */
public class AccountServiceImpl implements AccountService {

    //编程式事务管理,使用PlatformTransactionManager
//    private PlatformTransactionManager platformTransactionManager;


    //编程式事务管理,使用TransactionTemplate
//    private TransactionTemplate transactionTemplate;

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /*public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }*/

//    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
//        this.transactionTemplate = transactionTemplate;
//    }

   /**
     * 编程式事务管理，使用PlatformTransactionManager
     * @param out
     * @param in
     * @param money
     */
   /* public void transfer(String out, String in, Double money) {
        DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
        dtd.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);
        dtd.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_DEFAULT);
        TransactionStatus ds = platformTransactionManager.getTransaction(dtd);

        try {
            accountDao.outMoney(out, money);
            int a = 1/0;
            accountDao.inMoney(in, money);
            platformTransactionManager.commit(ds);
        } catch (TransactionException e) {
            platformTransactionManager.rollback(ds);
            e.printStackTrace();
        }
    }*/

   /* *//**
     * 编程式事务管理，使用TransactionTemplate
     * @param out
     * @param in
     * @param money
     *//*
    public void transfer(final String out, final String in, final Double money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                accountDao.outMoney(out, money);
            int a = 1/0;
                accountDao.inMoney(in, money);
                return null;
            }
        });
    }*/

    /**
     * 针对于每个service需要配置一个代理类
     * @param out
     * @param in
     * @param money
     */
    @Transactional
    public void transfer(String out, String in, Double money) {
        accountDao.outMoney(out, money);
        int a = 1 / 0;
        accountDao.inMoney(in, money);
    }
}
