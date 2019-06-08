package cn.itcast;

import org.junit.Test;

import static org.junit.Assert.*;




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

        import org.dom4j.Document;
        import org.dom4j.DocumentException;
        import org.dom4j.Element;
        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.Test;
        import org.dom4j.io.SAXReader;

        import org.junit.Test;

        import java.util.List;


public class Dom4jDemoTest {
    //得到某个具体的节点内容:第二本书的作者

    @Test
    public void test1() throws DocumentException {
        //得到Document对象
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book/xml");
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

    //得到所有元素节点
    //修改某个元素节点的主题内容
    //向指定元素节点中增加子元素节点
    //删除指定元素节点
    //操作XML文件属性
}

