package com.lxy.config;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * @author lxy
 * @time 2018-12-26 22:24
 **/
@Configuration
@ComponentScan(basePackages = {"com.lxy"})
@PropertySource("classpath:/jdbc.properties")
public class UserConfig {
    @Autowired
    private Environment env;//使用standardEnvironment

    @PostConstruct
    public void getProps(){
        System.out.println(env.getProperty("host.jdbc.url"));
        System.out.println(env.getProperty("host.jdbc.user"));
        System.out.println(env.getProperty("host.jdbc.password"));
    }

    /**
     * 使用beanNameAutoProxyCreator进行自动代理
     * @return
     */
   /* @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator(){
        BeanNameAutoProxyCreator beanNameAutoProxyCreator=new BeanNameAutoProxyCreator();
        //设置要创建代理的那些Bean的名字
        beanNameAutoProxyCreator.setBeanNames("studentService","teacherService");
        //设置拦截链名字(这些拦截器是有先后顺序的)
        beanNameAutoProxyCreator.setInterceptorNames("check");
        return beanNameAutoProxyCreator;
    }*/


 /*  @Bean
   public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
       DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
       return defaultAdvisorAutoProxyCreator;
   }*/

    /**
     * AspectJ自动生成代理
     * @return
     */
    @Bean
    public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator(){
       AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator = new AnnotationAwareAspectJAutoProxyCreator();
       annotationAwareAspectJAutoProxyCreator.setProxyTargetClass(true);
       return annotationAwareAspectJAutoProxyCreator;
   }

}
