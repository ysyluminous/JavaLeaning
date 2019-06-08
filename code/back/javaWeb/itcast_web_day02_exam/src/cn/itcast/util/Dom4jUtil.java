package cn.itcast.util;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

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
public class Dom4jUtil {
    public static Document getDocument() throws Exception{
        SAXReader reader = new SAXReader();
        return reader.read("src/exam.xml");
    }
    public static void write2xml(Document doucument) throws IOException {
        OutputStream out = new FileOutputStream("src/exam.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doucument);
        writer.close();
    }

}
