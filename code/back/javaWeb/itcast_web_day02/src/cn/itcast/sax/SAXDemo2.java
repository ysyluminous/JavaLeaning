package cn.itcast.sax;

import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

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
public class SAXDemo2 {
    //打印第二本书的作者
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        XMLReader reader = parser.getXMLReader();
        //读取xml文档

        reader.setContentHandler(new ContentHandler() {
            boolean isAuthor = false;  //是不是作者标签
            int index = 0; //作者标签的索引

            @Override
            public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
                if("作者".equals(qName))
                    isAuthor = true;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if(isAuthor&&index ==1){
                    System.out.print(new String(ch,start,length));
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                if ("作者".equals(qName)){
                    index++;
                }
                isAuthor = false;

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
        });
        reader.parse("src/book.xml");
    }
}
