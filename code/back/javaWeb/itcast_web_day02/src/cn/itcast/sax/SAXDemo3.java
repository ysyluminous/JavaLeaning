package cn.itcast.sax;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.domain.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.10.24
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class SAXDemo3 {
    //读取xml中的内容封装到JavaBean中
    public static void main(String args[]) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XMLReader reader = parser.getXMLReader();
        final List books = new ArrayList();//存放所有的书
        reader.setContentHandler(new DefaultHandler() {
            Book book = null;
            String currentTagName = null;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if ("书".equals(qName)) {
                    book = new Book();
                }
                //书架
                currentTagName = qName;
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if ("书".equals(qName)) {
                    //匿名内部类访问局部变量要加final
                    books.add(book);
                    book = null;
                }
                currentTagName = null;
            }

            @Override
            public void characters(char[] ch , int start, int length) throws SAXException {
                if ("书名".equals(currentTagName)) {
                    book.setName(new String(ch, start, length));
                }
                if ("作者".equals(currentTagName)) {
                    book.setAuthor(new String(ch, start, length));
                }
                if ("售价".equals(currentTagName)) {
                    book.setPrice(Float.parseFloat(new String(ch, start, length)));
                }
            }
        });
        reader.parse("src/book.xml");

        //验证代码
        for (Object b : books) {
            System.out.println(b);
        }
    }
}

//默认适配器设计模式
//DefaultHandler的实现代码
class MyDefaultHandler implements ContentHandler {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

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