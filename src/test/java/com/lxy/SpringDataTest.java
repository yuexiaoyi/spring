package com.lxy;

import com.lxy.config.JpaConfig;
import com.lxy.dao.IStudentDao;
import com.lxy.dao.StudentRepository;
import com.lxy.vo.StudentVO;
import com.lxy.vo.UserVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lxy
 * @time 2019-02-23 12:14
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class})
public class SpringDataTest {

    @Autowired
    private StudentRepository studentRepository;

//    private AnnotationConfigApplicationContext ctx;

//    @Before
//    public void init(){
//        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
//        studentRepository = (StudentRepository) ctx.getBean("studentRepository");
//    }

    @Test
    public void testAdd(){
        StudentVO vo = new StudentVO("test",20,20);
        studentRepository.save(vo);
    }

    @Test
    public void testUpdate(){
        StudentVO vo = new StudentVO("testupdate",20,20);
        vo.setId(5L);

        studentRepository.saveAndFlush(vo);
    }

    @Test
    public void testDelete(){
        studentRepository.deleteById(5L);
    }

    @Test
    public void testFind(){
        studentRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void testFindByAge(){
        studentRepository.findByAge(20).forEach(System.out::println);
    }

}
