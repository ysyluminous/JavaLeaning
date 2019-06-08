package bxd_day19;

import java.io.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.04
 *
 * Summary: 字符流：
 *              FileReader、FileWriter
 *              BufferedReader、BufferedWriter
 *          字节流:
 *              FileInputStream、FileOutputStream
 *              BufferedInputStream、BufferedOutputStream
 *
 *          通过刚才的键盘录入一行数据并打印其大写，发现其实就是读取一行数据的原理。
 *          也就是readLine方法。
 *          能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？
 *
 *          readLine方法是字符流BufferedReader类中的方法。
 *          而键盘录入的read方法是字节流InputStream的方法。
 *          那么能不能将字节流转成字符流在使用字符流缓冲去读readLine方法呢？
 *
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class TransStreamDemo {
    public static void main(String args[]) throws IOException {
//        //获取键盘录入对象
//        InputStream in = System.in;
//
//        //将字节流 对象转成字符流对象，使用转换流。InputStreamReader
//        InputStreamReader isr = new InputStreamReader(in);
//
//        //为了提高效率，讲字符串进行缓冲区技术高效操作。使用BufferedReader
//        BufferedReader bufr  = new BufferedReader(isr);

        //键盘录入最常见写法。
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));



//        OutputStream out = System.out;
//        OutputStreamWriter osw = new OutputStreamWriter(out);
//        BufferedWriter bufw = new BufferedWriter(osw);

        BufferedWriter bufw =
                new BufferedWriter(new OutputStreamWriter(System.out));



        String line = null;

        while ((line = bufr.readLine()) != null){
            if ("over".equals(line)){
                break;
            }
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();


//            System.out.println(line.toUpperCase());
        }
        bufw.close();
    }
}
