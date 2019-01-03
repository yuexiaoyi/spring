package com.lxy.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 检查用户的权限,增强处理，切面的定义放在UserConfig或者Schema来实现
 */
@Component("check")
public class CheckAuthority implements MethodBeforeAdvice,AfterReturningAdvice,ThrowsAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("执行MethodBeforeAdvice方法！");
        System.out.println(method.getName());
        if(method.getName().indexOf("insert") != -1){
            System.out.println("检查是否有insert权限！");
            for(Object obj:objects){
                System.out.println(obj);
            }

            System.out.println(o);
        }
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行AfterReturningAdvice方法");
        System.out.println(o);
        System.out.println(method.getName());
        for(Object obj:objects){
            System.out.println(obj);
        }
        System.out.println(o1);
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
        System.out.println("执行ThrowsAdvice方法");
        System.out.println(method.getName());
        for(Object obj:args){
            System.out.println(obj);
        }

        System.out.println(ex.getMessage());
    }
}
