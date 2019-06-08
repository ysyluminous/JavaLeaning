package bxd_day18;

import java.io.FileWriter;
import java.io.IOException;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.30
 *
 * Summary:字符流和字节流
 *         字节流两个基类
 *              InputStream、OutputStream
 *          字符流两个基类
 *              Reader、Writer
 *          先学习一下字符流的特点。
 *              既然是IO流是用于操作数据的，那么数据最常见的体系形式是文件。
 *          那么先以操作为主来演示。
 *          需求：在硬盘上，创建一个文件并写入一些文字数据。
 *
 *          找到一个专门用于操作文件的Writer子类对象。FileWriter，后缀名是父类名，前椎名是该流对象的功能。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象。该对象一被初始化就必须要明确被操作的文件。
        //而且该文件会被创建到指定目录下。如果该目录下已经有同名文件将被覆盖。
        //其实该步就是在明确数据要存放的目的地。
        FileWriter fw = new FileWriter("demo.txt");

        //调用write方法，将字符串写入到流中
        fw.write("abcde");

        //刷新流对象中的缓冲中的数据。
//      将数据刷到目的地中去。
        fw.flush();

//        fw.write("haha");
//        fw.flush();

        //关闭流资源，关闭之前会刷新一次内部的缓冲中的数据。将数据刷新到目的地中，和flush的区别：
//        flush刷新后，流可以继续使用，close会将流关闭。
        fw.close();

//        fw.write("haha");
    }
}
