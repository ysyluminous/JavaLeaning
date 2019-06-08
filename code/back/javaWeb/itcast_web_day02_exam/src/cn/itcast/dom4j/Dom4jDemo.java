package cn.itcast.dom4j;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.02
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


public class Dom4jDemo {
    //得到某个具体的节点内容:第二本书的作者

    @Test
    public void test1() throws DocumentException {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();
        //得到第二本书的作者
        List<Element> es = root.elements("书");
        Element e = es.get(1);
        Element author = e.element("作者");
        //拿到内容，打印输出
        //System.out.println(author.getTest);
        Assert.assertEquals("毕向东",author.getText());
    }

    @Test
    public void test11() throws DocumentException {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");

        String xpath = "//书[2]/作者";
        Node author = document.selectSingleNode(xpath);





//        //得到根元素
//        Element root = document.getRootElement();
//        //得到第二本书的作者
//        List<Element> es = root.elements("书");
//        Element e = es.get(1);
//        Element author = e.element("作者");
//        //拿到内容，打印输出
//        System.out.println(author.getTest);
        Assert.assertEquals("毕向东",author.getText());
    }

    //得到所有元素节点
    @Test
    public void test2() throws DocumentException {
        //得到document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();
        treeWalk(root);//遍历所有的元素，打印他的名称
    }

    private void treeWalk(Element root) {
        System.out.print(root.getName());

        //节点的数量
        int count = root.nodeCount();
        for (int i = 0;i < count;i++){
            Node node = root.node(i);//取索引上节点
            if (node.getNodeType() == node.ELEMENT_NODE){
                treeWalk((Element)node);
            }
        }
    }

//    private void treeWalk(Element root) {
//        System.out.print(root.getName());
//        List<Element> es = root.elements();
//        for (Element e:es){
//            treeWalk(e);
//        }
//    }



    //修改某个元素节点的主题内容：修改第二本书的售价
    @Test
    public void test3() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();
        //得到第二本书的售价
        Element secondBook = (Element) root.elements().get(1);
        Element secondBookPrice =secondBook.element("售价");
        //设置主题内容
        secondBookPrice.setText("18.00");
        //写回XML
        OutputStream out = new FileOutputStream("src/book.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("UTF-8");//指定码表，这是默认编码
        XMLWriter writer = new XMLWriter(out,format);
            writer.write(document);
        writer.close();
    }
    //向指定元素节点中增加子元素节点：在第一本书的售价前面添加内部价
    @Test
    public void test5() throws Exception {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document =  reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();

        //找到第一本书
        Element firstBook = root.element("书");
        //得到第一本书的所有子元素:List
        List<Element> children = firstBook.elements();
        //借助DocumentHelper创建内部价元素
        Element price = DocumentHelper.createElement("内部价");
        price.setText("99");
        //连接到老3的位置上
        children.add(2,price);

        //写回XML文档
        OutputStream out = new FileOutputStream("src/book.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("UEF-8");指定编码，这是默认编码
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(document);
        writer.close();

    }
    //删除指定元素节点
    @Test
    public void test6() throws DocumentException {
        //得到Docuemnt对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();

        //找到第一本书
        Element firstBook = root.element("书");
//      ？？？？？？？？？？？？？？？？？？？？？？？？？

        //自己不能删自己
        Element price = firstBook.element("批发价");
        firstBook.remove(price);
    }
    //操作XML文件属性:第一本书添加一个出版社属性
    @Test
    public void test7() throws DocumentException, IOException {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        //得到根元素
        Element root = document.getRootElement();
        //得到第一本书
        Element firstbok = root.element("书");

        firstbok.addAttribute("出版社","传智播客");

        //写回XML文档
        OutputStream out = new FileOutputStream("src/book.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
//        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(document);
        writer.close();
    }

    //获取第一本书的出版社属性值
    @Test
    public void test8() throws DocumentException {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document =reader.read("src/book.xml");

        //得到根元素
        Element root = document.getRootElement();

        //找到第一本书
        Element firstBook = root.element("书");

        String value = firstBook.attributeValue("出版社");
        Assert.assertEquals("传智播客",value);
    }
}

