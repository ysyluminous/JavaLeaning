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
 * Summary:	第二种方式，通过字符数组进行读取
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileReaderDemo2 {
    public static void main(String args[]) throws IOException {
        FileReader fr = new FileReader("demo.txt");

        //定义一个字符数组，用于存储读到字符
        //该read(char[])返回的是读到字符。
        char[] buf = new char[1024];

        int num = 0;
        while ((num = fr.read(buf)) != -1){
            System.out.println(new String(buf,0,num));
        }

//        int num = fr.read(buf);
//        System.out.println("num = " + num + ".."+ new String(buf));
//
//        int num1 = fr.read(buf);
//        System.out.println("num = " + num1 + ".."+ new String(buf));
//
//        int num2 = fr.read(buf);
//        System.out.println("num = " + num2 + ".."+ new String(buf));
//
//        int num3 = fr.read(buf);
//        System.out.println("num = " + num3 + ".."+ new String(buf));


    }
}
