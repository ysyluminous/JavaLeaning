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
 * Summary:	演示对已有文件的续写。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class FileWriterDemo3 {
    public static void main(String args[]){
//      传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾处进行数据读写。
        FileWriter fw = null;
        try {
             fw = new FileWriter("demo.txt",true);
            fw.write("nihao\r\nxiexie");
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
