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
public interface IStudentDao {

    /**
     * 添加学生信息到XML中
     * @param s
     * @return
     */
    boolean createStudent(Student s);

    /**
     * 根据准考证号查询学生信息
     * @param examid
     * @return 如果学生不存在，返回null
     */
    Student findStudent(String examid);

    /**
     * 根据学生姓名删除学生
     * @param name
     * @return 如果人不存在也返回false
     */
    boolean deleteStudent(String name) throws Exception;

}
