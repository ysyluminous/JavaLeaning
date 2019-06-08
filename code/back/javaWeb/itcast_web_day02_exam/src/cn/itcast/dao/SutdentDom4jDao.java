package cn.itcast.dao;
import cn.itcast.domain.Student;
import cn.itcast.util.Dom4jUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

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
public class SutdentDom4jDao implements IStudentDao{

    /**
     * 添加学生信息到XML中
     * @paam s
     * @return
     *
     */
    public boolean createStudent(Student s){
        boolean result = false;

        try{
            //得到Document对象
            Document document = Dom4jUtil.getDocument();
            //得到根元素
            Element root = document.getRootElement();
            //加数据即可<student>
            Element studentE = root.addElement("student")
                    .addAttribute("examid",s.getExamid("888"))
                    .addAttribute("idcard",s.getIdcard());
            studentE.addElement("name").setText(s.getName());
            studentE.addElement("grade").setText(s.getGrade()+"");
            studentE.addElement("location").setText(s.getLocation());

            //写回XML文档
            Dom4jUtil.write2xml(document);
            result = true;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    /**
     * 根据学生姓名删除学生
     * @param name
     * @return 如果人不存在也返回false
     */
    public boolean deleteStudent(String name) throws Exception {
        boolean result = false;

        try{
            //得到Document对象
            Document document = Dom4jUtil.getDocument();
            //选择所有的name元素
            List<Node> nodes = document.selectNodes("//name");
            //遍历：判断元素的内容是否与参数一致
            for (Node n:nodes
                    ) {
                if (n.getText().equals(name))
                    //用他的爷爷删除他的爸爸
                    n.getParent().getParent().remove(n.getParent());
            }
            //写回XML文档
            Dom4jUtil.write2xml(document);
            result = true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 根据准考证号查询学生信息
     * @param examid
     * @return 如果学生不存在，返回null
     */

    @Override
    public Student findStudent(String examid) {
        Student s = null;
        try{
            Document document = Dom4jUtil.getDocument();
            Node node = document.selectSingleNode("//student[@examid='"+examid+"']");
            if (node != null){
                Element e = (Element)node;
                s = new Student();
                s.setExamid(examid);
                s.setName(e.element("name").getText());
                s.setLocation(e.elementText("location"));
                s.setIdcard(node.valueOf("@idcard"));
                s.setGrade(Float.parseFloat(e.elementText("grade")));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return s;
    }


}
