package com.lxy;

import static org.junit.Assert.assertTrue;

import com.lxy.aop.CheckAuthority;
import com.lxy.aop.LogAspect;
import com.lxy.config.UserConfig;
import com.lxy.service.UserService;
import com.lxy.service.impl.UserServiceImpl;
import com.lxy.vo.UserVO;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
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
    public void test1(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService service = (UserServiceImpl)applicationContext.getBean("userService");
        UserVO vo = new UserVO(11,"xiaoyi","abc");
        service.insertUser(vo);
    }

    /**
     * 测试AOP的功能
     */
    @Test
    public void testAop(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService target = (UserServiceImpl)applicationContext.getBean("userService");
        CheckAuthority check = (CheckAuthority) applicationContext.getBean("check");

        UserVO vo = new UserVO(11,"xiaoyi","abc");
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(check);

        UserService service = (UserService) pf.getProxy();

//        service.insertUser(vo);
        service.insertUser();
//        service.updateUser(vo);
    }

    /**
     * 测试aop自动生成代理
     */
    @Test
    public void testAopProxy(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserConfig.class);

        UserService student = (UserService) ctx.getBean("studentService");
        UserService teacher = (UserService) ctx.getBean("teacherService");
        UserVO vo = new UserVO(11,"xiaoyi","abc");
        student.insertUser(vo);
        student.deleteUser(vo);
        student.updateUser(vo);
        teacher.insertUser(vo);
        teacher.deleteUser(vo);
        teacher.updateUser(vo);

    }

    /**
     * 测试AspectJ,需要手动生成代理
     */
    @Test
    public void testAopAspectj(){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService target = (UserService) ctx.getBean("studentService");
//		UserService target = (StudentServiceImpl) ctx.getBean("studentService");

        AspectJProxyFactory ajf = new AspectJProxyFactory();
        ajf.setTarget(target);
        ajf.addAspect(LogAspect.class);

        UserService student = ajf.getProxy();

        UserVO vo = new UserVO(11,"xiaoyi","abc");
        student.insertUser(vo);
//		student.deleteUser(vo);
//		student.updateUser(vo);

    }

    /**
     * 测试AspectJ,自动生成代理类
     */
    @Test
    public void testAopAspectjProxy(){

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(UserConfig.class);
        UserService student = (UserService) ctx.getBean("studentService");

        UserVO vo = new UserVO(11,"xiaoyi","abc");
        student.insertUser(vo);
//		student.updateUser(vo);

    }

}
