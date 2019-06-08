package cn.itcast.test;

import static org.junit.Assert.*;

import cn.itcast.dao.IStudentDao;
import cn.itcast.dao.SutdentDom4jDao;
import cn.itcast.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SutdentDom4jDao Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮһ�� 9, 2016</pre> 
* @version 1.0 
*/ 
public class SutdentDom4jDaoTest { 
    private  static IStudentDao dao;

@Before
    public  void init(){
        dao = new SutdentDom4jDao();
    }

@After
    public  void destory(){
        dao = null;
    }


/** 
* 
* Method: createStudent(Student s) 
* 
*/ 
@Test
public void testCreateStudent() throws Exception {
    Student s = new Student();
    s.setIdcard("666");
    s.setName("姚斯元");
    s.setLocation("漯河");
    s.setGrade(100);
    s.setExamid("121");
    boolean b = dao.createStudent(s);
    Assert.assertTrue(b);


//TODO: Test goes here... 
}



    /**
     *
     * Method: findStudent(String examid)
     *
     */
    @Test
    public void testFindStudent() throws Exception {
        Student s = dao.findStudent("121");
        Assert.assertNotNull(s);
        s=dao.findStudent("834");
        Assert.assertNull(s);

    }




    /**
* 
* Method: deleteStudent(String name) 
* 
*/ 
@Test
public void testDeleteStudent() throws Exception { 
    boolean b = dao.deleteStudent("姚斯元");
    Assert.assertTrue(b);
}



} 
