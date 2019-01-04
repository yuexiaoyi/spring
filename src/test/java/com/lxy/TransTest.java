package com.lxy;

import com.abc.aop.GreetingAspect;
import com.abc.aop.StuBeforeAdvice;
import com.abc.domain.Student;
import com.abc.service.UserService;
import com.abc.service.impl.UserServiceImpl;
import com.abc.service.impl.Waiter;
import com.abc.transaction.service.AccountService;
import com.lxy.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class TransTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testTransaction(){
        //编程式
     /*   ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService service = (AccountService)context.getBean("accountService");
        service.transfer("aaa","bbb",100d);*/

        //声明式事务管理 TransactionProxyBeanFactory。需要使用代理类
      /*  ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService service = (AccountService)context.getBean("accountServiceProxy");
        service.transfer("aaa","bbb",100d);*/

       //声明式事务管理，使用aspectj
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AccountService service = (AccountService)context.getBean("accountService");
        service.transfer("aaa","bbb",100d);
    }
}
