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
 * Summary:	IO异常的处理方式。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileWriterDemo2 {
    public static void main(String args[])  {

        FileWriter fw = null;
        try {
            fw = new FileWriter("c:\\demo.txt");
            fw.write("avdsad ");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fw!=null){
                    fw.close();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
