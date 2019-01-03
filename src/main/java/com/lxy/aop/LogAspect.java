package com.lxy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author lxy
 * @time 2018-12-29 20:30
 * 日志的切面，通过Aspect来实现。
 **/
@Aspect
@Component
public class LogAspect {
    /**
     * 在service前切面
     */
    @Before(value = "execution(* com.lxy.service.impl..*Impl.*(..))")
    public void beforeService(JoinPoint jt){
        //获取连接点方法的参数
        Object[] objs = jt.getArgs();
        for(Object o : objs){
            System.out.println(o);
        }
        //获取目标对象
        System.out.println(jt.getTarget());
        //获取连接点方法的签名
        System.out.println(jt.getSignature());
        //指代理对象本身
        System.out.println(jt.getThis());
        System.out.println("在service前添加日志");
    }

    /**
     * 在service后面添加切面
     */
    @AfterReturning(value = "execution(* com.lxy.service..*Impl.*(..))")
    public void afterService(){
        System.out.println("在service后添加日志");
    }

   /**
     * 在dao前添加切面
     */
    @Before(value = "execution(* com.lxy.dao.*.*(..))")
    public void beforeDao(){
        System.out.println("在Dao前添加日志");
    }

    /**
     * 在dao后添加切面
     */
    @AfterReturning(value = "execution(* com.lxy.dao.*.*(..))")
    public void afterDao(){
        System.out.println("在Dao后添加日志");
    }
}
