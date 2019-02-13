package com.lxy;

import com.lxy.config.JpaConfig;
import com.lxy.dao.IStudentDao;
import com.lxy.vo.StudentVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author lxy
 * @time 2019-02-12 11:26
 **/
public class JpaTest {

    private IStudentDao dao;

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void init(){
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        dao = (IStudentDao) ctx.getBean("studentDaoImpl");
    }

    @Test
    public void testSave(){
        StudentVO vo = new StudentVO("11",11,11.11);
        dao.save(vo);
    }

    @Test
    public void testUpdate(){
        StudentVO vo = new StudentVO("11update",11,11.11);
        vo.setId(1L);
        dao.update(vo);
    }

    @Test
    public void testDel(){
        dao.delete(1L);
    }

    @Test
    public void testFind(){
        dao.findById(2L);
    }

    @Test
    public void testFindList(){
        dao.findAll();
    }
}
