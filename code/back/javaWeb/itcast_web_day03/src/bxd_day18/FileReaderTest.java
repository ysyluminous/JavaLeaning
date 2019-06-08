package bxd_day18;

import java.io.FileReader;
import java.io.IOException;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.30
 *
 * Summary:	读取一个.java 文件 并打印在控制台上
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileReaderTest {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("DateDemo.java");

        char [] buf = new char[1024];

        int num = 0;

        while ((num = fr.read(buf)) != -1){
            System.out.println(new String(buf,0,num));
        }

        fr.close();
    }
}
