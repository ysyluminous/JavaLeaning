package bxd_day19;

import java.io.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.03
 *
 * Summary:	演示MP3的复制，通过缓冲区
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class CopyMp3 {
    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        copy_2();
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "毫秒");
    }


    public static void copy_2() throws IOException{
        MyBufferedInputStream bufis  = new MyBufferedInputStream(new FileInputStream("1.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("3.mp3"));

        int by = 0;

        while ((by = bufis.myRead()) != -1){
            bufos.write(by);
        }

        bufos.close();
        bufis.MyClose();

    }




        //通过字节流的缓冲区完成复制
    public static void copy_1() throws IOException {
        BufferedInputStream bufis  = new BufferedInputStream(new FileInputStream("1.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("2.mp3"));

        int by = 0;

        while ((by = bufis.read()) != -1){
            bufos.write(by);
        }

        bufos.close();
        bufis.close();

    }
}
