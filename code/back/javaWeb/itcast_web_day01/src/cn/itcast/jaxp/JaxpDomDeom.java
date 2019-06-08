package cn.itcast.jaxp;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//利用Jaxp进行DOm方式解析
public class JaxpDomDeom {

    public static void main(String[] args) throws Exception {
        //得到解析工厂DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //得到解析器DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //解析指定的XML文档，得到代表内存DOM树的Document对象
        Document document = builder.parse("src/book.xml");
        test8(document);
    }
    //	1、得到某个具体的节点内容:打印第2本书的作者
    public static void test1(Document document){
        //根据标签的名称获取所有的作者元素
        NodeList nl = document.getElementsByTagName("作者");
        //按照索引取第2个作者元素
        Node node = nl.item(1);
        //打印该元素的文本
        String text = node.getTextContent();
        System.out.println(text);
    }
    //	2、遍历所有元素节点:打印元素的名称
    public static void test2(Node node){
        //判断当前节点是不是一个元素节点
        if(node.getNodeType()==Node.ELEMENT_NODE){
            //如果是：打印他的名称
            System.out.println(node.getNodeName());
        }
        //如果不是：找到他的孩子们
        NodeList nl = node.getChildNodes();
        int len = nl.getLength();
        for(int i=0;i<len;i++){
            //遍历孩子们：递归
            Node n = nl.item(i);
            test2(n);
        }
    }

    //	3、修改某个元素节点的主体内容:把第一本书的售价改为38.00元
    public static void test3(Document document) throws Exception{
        //找到第一本书的售价
        NodeList nl = document.getElementsByTagName("售价");
        //设置其主体内容
        Node node = nl.item(0);
        node.setTextContent("38.00元");
        //把内存中Documeng树写回XML文件中
        TransformerFactory facotry = TransformerFactory.newInstance();
        Transformer ts = facotry.newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));

    }
    //	4、向指定元素节点中增加子元素节点:第一本中增加子元素<内部价>99.00</内部价>
    public static void test4(Document document) throws Exception{
        //创建一个新的元素并设置其主体内容
        Element e = document.createElement("内部价");
        e.setTextContent("99.00元");
        //找到第一本书元素
        Node firstBookNode = document.getElementsByTagName("书").item(0);
        //把新节点挂接到第一本书上
        firstBookNode.appendChild(e);
        //把内存中Documeng树写回XML文件中
        TransformerFactory facotry = TransformerFactory.newInstance();
        Transformer ts = facotry.newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
    }
    //	5、向指定元素节点上增加同级元素节点:在第一本书的售价前面增加批发价
    public static void test5(Document document) throws Exception{
        //创建一个新的元素并设置其中的主体内容
        Element e = document.createElement("批发价");
        e.setTextContent("58.00元");
        //找到第一本书的售价
        Node firstPrice = document.getElementsByTagName("售价").item(0);
        //在售价的前面加入新建的元素:增加子元素一定要使用父元素来做
        firstPrice.getParentNode().insertBefore(e, firstPrice);
        //把内存中Documeng树写回XML文件中
        TransformerFactory facotry = TransformerFactory.newInstance();
        Transformer ts = facotry.newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
    }
    //	6、删除指定元素节点:删除内部价
    public static void test6(Document document) throws Exception{
        //找到内部价节点，用爸爸删除
        Node n = document.getElementsByTagName("内部价").item(0);
        n.getParentNode().removeChild(n);
        //把内存中Documeng树写回XML文件中
        TransformerFactory facotry = TransformerFactory.newInstance();
        Transformer ts = facotry.newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
    }
    //	7、操作XML文件属性:打印第一本书的出版社
    public static void test7(Document document) throws Exception{
        //得到第一本书
        Node n = document.getElementsByTagName("书").item(0);
        //打印指定属性的取值
        Element e = (Element)n;
        System.out.println(e.getAttribute("出版社"));
    }
    //  8、添加一个出版社属性给第二本书
    public static void test8(Document document) throws Exception{
        //得到第二本书
        Node n = document.getElementsByTagName("书").item(1);
        //打印指定属性的取值
        Element e = (Element)n;
        e.setAttribute("出版社", "上海传智");
        //把内存中Documeng树写回XML文件中
        TransformerFactory facotry = TransformerFactory.newInstance();
        Transformer ts = facotry.newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/book.xml"));
    }
}
