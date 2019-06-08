package cn.itcast.sax;


import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.10.24
 *
 * Summary:	SAX解析原理：
 *              通过读取器读取XML文档，当读到了文档的某一部分时，
 *              元素的开始，文本，元素的结束，文档的结束，
 *              都会调用事件处理器的对应方法，读到的数据，以参数的形式传递给对应的方法。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class SAXDemo1 {
    public static void main(String args []) throws Exception {
        //得到解析工厂SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //得到解析器SAXParser
        SAXParser parser = factory.newSAXParser();
        //得到XML读取器 XMLReader
        XMLReader reader = parser.getXMLReader();
        //注册内容处理器：ContentHandler
        reader.setContentHandler(new MyContentHandler());
        //读取XML文档
        reader.parse("src/book.xml");
    }
}
class MyContentHandler implements ContentHandler{
    //解析到文档开始时被调用
    @Override
    public void startDocument() throws SAXException {
        System.out.println("解析到了文档的开始：");
    }
    //解析到元素开始时被调用  qName元素名称
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.println("解析到了元素的开始："+qName);

    }
    //解析到文本内容时被调用
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("文本内容："+new String (ch,start,length));
    }

    //解析到元素结束时被调用
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("解析到了元素的结束："+qName);
    }

    //解析到文档结束时被调用
    @Override
    public void endDocument() throws SAXException {
        System.out.println("解析到了文档的结束");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}








