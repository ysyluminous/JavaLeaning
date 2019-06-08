package bxd_day19;

import java.io.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.01
 *
 * Summary:	通过缓冲区复制一个.java文件
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class CopyTextByBuf {
    public static void main(String args[]){
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try {
            bufr = new BufferedReader(new FileReader("BufferedWriterDemo.java"));
            bufw = new BufferedWriter(new FileWriter("bufWriter_copy.txt"));

            String line = null;

            while ((line = bufr.readLine()) != null){
//                System.out.println();
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException("读写失败");
            // TODO: 2016.12.01 两个流抛异常
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (bufr != null){
                    bufr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("读写失败");
            }
        }
    }
}
