package cn.itcast.util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
//操作XML的工具类
//工具类中的异常可以抛也可以处理
public class DocumentUtil {
    public static Document getDocument() throws Exception{
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse("src/exam.xml");
    }
    public static void write2xml(Document document)throws Exception{
        Transformer ts = TransformerFactory.newInstance().newTransformer();
        ts.transform(new DOMSource(document), new StreamResult("src/exam.xml"));
    }
}
