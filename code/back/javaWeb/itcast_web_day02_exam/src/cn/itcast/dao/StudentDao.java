package cn.itcast.dao;

import cn.itcast.domain.Student;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.09
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class StudentDao implements IStudentDao{
    /**
     * 添加学生信息到XML文档中
     * @param s
     * @return
     */
    @Override
    public boolean createStudent(Student s) {
        return false;
    }

    @Override
    public Student findStudent(String examid) {
        return null;
    }

    @Override
    public boolean deleteStudent(String name) {
        return false;
    }
}
