package cn.itcast.test;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoTest {

    public static void main(String[] args) {
        StudentDao dao = new StudentDao();
//
//		Student s = new Student();
//		s.setIdcard("555");
//		s.setExamid("666");
//		s.setName("李宗瑞");
//		s.setLocation("台北");
//		s.setGrade(100);
//
//		dao.createStudent(s);
		Student s = dao.findStudent("666");
		System.out.println(s);
//        boolean b = dao.deleteStudent("李宗瑞");
//        System.out.println();
    }

}
