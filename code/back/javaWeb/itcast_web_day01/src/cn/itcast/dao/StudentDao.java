package cn.itcast.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student;
import cn.itcast.util.DocumentUtil;
//异常：抛的话，上层能解决才行
//上一层如果处理不了，自己必须处理。

public class StudentDao {
    /**
     * 添加学生信息到XML中
     * @param s
     * @return
     */
    public boolean createStudent(Student s){
        //目标：在根元素exam中添加student子元素
        boolean result = false;
        try {
            Document document = DocumentUtil.getDocument();
            //创建name、location、grade元素并设置其主体内容
            Element nameE = document.createElement("name");
            nameE.setTextContent(s.getName());
            Element locationE = document.createElement("location");
            locationE.setTextContent(s.getLocation());
            Element gradeE = document.createElement("grade");
            gradeE.setTextContent(s.getGrade()+"");
            //创建student元素，并设置其属性
            Element studentE = document.createElement("student");
            studentE.setAttribute("idcard", s.getIdcard());
            studentE.setAttribute("examid", s.getExamid());//CTRL+ALT+ARROW

            studentE.appendChild(nameE);
            studentE.appendChild(locationE);
            studentE.appendChild(gradeE);
            //得到exam元素，把student挂接上去
            Node node = document.getElementsByTagName("exam").item(0);
            node.appendChild(studentE);
            //写回XML文件中
            DocumentUtil.write2xml(document);
            result = true;
        } catch (Exception e) {
            throw new RuntimeException(e);//异常转义。异常链
        }
        return result;
    }
    /**
     * 根据准考证号查询学生信息
     * @param examid
     * @return 如果学生不存在，返回null
     */
    public Student findStudent(String examid){
        Student s = null;

        try{
            //得到Document对象
            Document document = DocumentUtil.getDocument();
            //得到所有的student元素
            NodeList nl = document.getElementsByTagName("student");
            //遍历student元素，判断他的examid属性的取值是否与参数匹配
            for(int i=0;i<nl.getLength();i++){
                Node node = nl.item(i);
//				if(node.getNodeType()==Node.ELEMENT_NODE){
//					Element e = (Element)node;
                if(node instanceof Element){
                    Element e = (Element)node;
                    if(e.getAttribute("examid").equals(examid)){
                        //如果匹配：说明找到了学生；创建学生对象
                        s = new Student();
                        //设置学生对象的各个属性取值
                        s.setExamid(examid);
                        s.setIdcard(e.getAttribute("idcard"));
                        s.setName(e.getElementsByTagName("name").item(0).getTextContent());
                        s.setLocation(e.getElementsByTagName("location").item(0).getTextContent());
                        s.setGrade(Float.parseFloat(e.getElementsByTagName("grade").item(0).getTextContent()));
                    }
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }

        return s;
    }
    /**
     * 根据学生姓名删除学生
     * @param name
     * @return 如果人不存在也返回false
     */
    public boolean deleteStudent(String name){
        boolean result = false;
        try{
            //得到Document对象
            Document document = DocumentUtil.getDocument();
            //得到所有的name元素
            NodeList nl = document.getElementsByTagName("name");
            //遍历name元素，判断其主体内容是否与参数一致
            for(int i=0;i<nl.getLength();i++){
                //如果一致：找到他的爸爸的爸爸，删除它的爸爸
                Node n = nl.item(i);
                if(n.getTextContent().equals(name)){
                    n.getParentNode().getParentNode().removeChild(n.getParentNode());
                    //写回XML文档
                    DocumentUtil.write2xml(document);
                    result = true;
                    break;
                }
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }
}
