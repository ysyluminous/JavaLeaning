package bxd_day19;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.02
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class LineNumberReaderDemo {
    public static void main(String args[]){
        try {
            FileReader fr = new FileReader("PersonDemo.java");
            LineNumberReader lnr = new LineNumberReader(fr);

            String line = null;
            lnr.setLineNumber(100);
            try {
                while ((line = lnr.readLine()) != null){
                    System.out.println(lnr.getLineNumber() + ":"+ line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}


//todo:练习：做一个带行号的缓冲区对象