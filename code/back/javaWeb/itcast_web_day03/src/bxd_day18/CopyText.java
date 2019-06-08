package bxd_day18;

import java.io.FileReader;
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
 * Summary:	讲一个C盘文件复制到D盘
 *          复制的原理：
 *          其实就是将C盘文件数据存储到D盘的一个文件中。
 *
 *          步骤：
 *          1.在D盘创建一个文件，用于存储C盘文件中的数据。
 *          2.定义读取流和C盘文件关联。
 *          3.通过不断的读写完成数据存储。
 *          4.关闭资源。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class CopyText {
    public static void main(String args[]){

    }

    //
    public static void coyp_2(){
        FileReader fr = null;
        FileWriter fw = null;

        try{
            fw = new FileWriter("SystemDemo_copy.txt");
            fr = new FileReader("SystemDemo.java");

            char [] buf = new char[1024];

            int len = 0;
            while ((len = fr.read(buf)) != -1){
                fw.write(buf,0,len);
            }
        }
        catch(IOException e){
            throw  new RuntimeException("读写失败");

        }
        finally{
            if (fr != null)
                try{
                    fr.close();
                }
                catch (IOException e){
                }
            if (fw != null)
                try{
                    fw.close();
                }
                catch (IOException e){

                }
        }
    }





        //从C盘读一个字符，就从D盘写一个字符。
    public static void coyp_1() throws IOException {
        //创建目的地。
        FileWriter fw = new FileWriter("RuntimeDemo_copy.txt");

        //与已有文件关联。
        FileReader fr = new FileReader("RuntimeDemo.java");

        int ch = 0;

        while ((ch = fr.read()) != -1){
            fw.write(ch);
        }

        fr.close();
        fw.close();
    }
}
