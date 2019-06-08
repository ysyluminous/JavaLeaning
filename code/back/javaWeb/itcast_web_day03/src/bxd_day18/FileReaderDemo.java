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
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileReaderDemo {
    public static  void main(String args[]) throws IOException {
        //创建一个文件读取流对象和指定名称的文件关联。
        //保证该文件是已经存在的。如果不存在会发生异常，文件找不到异常。
        FileReader  fr = new FileReader("demo.txt");

//     调用读取流对象的Read方法。

//        read方法一次读一个字符，而且会自动往下读。

//      读到末尾就返回-1
//        int ch1 = fr.read();
//        System.out.println("ch = "+ (char)(ch1));
//
//
//        int ch2 = fr.read();
//        System.out.println("ch = "+ (char)(ch2));
//
//
//        int ch3 = fr.read();
//        System.out.println("ch = "+ (char)(ch3));
//
//
//        int ch4 = fr.read();
//        System.out.println("ch = "+ (ch4));


//        while(true){
//            int ch = fr.read();
//            if (ch == -1){
//                break;
//            }
//            System.out.println("ch = "+ (char)(ch));
//        }

        int ch = 0;
        while ((ch = fr.read()) != -1){
            System.out.println();
        }


        fr.close();
    }
}
