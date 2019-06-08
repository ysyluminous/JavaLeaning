package bxd_day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

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



class MyLineNumberReader extends  MyBufferedReader{
    private int lineNumber;

    MyLineNumberReader(Reader r) {
        super(r);
    }

    public String myReaderLine() throws IOException {
        lineNumber++;
        return super.myReadLine();
    }

    public void setLineNumber(int lineNumber){
        this.lineNumber = lineNumber;
    }
    public int getLineNumber(){
        return lineNumber;
    }
}





//
//class MyLineNumberReader{
//    private Reader r;
//    private int lineNumber;
//
//    MyLineNumberReader(Reader r){
//        this.r = r;
//    }
//
//    public int getLineNumber() {
//        return lineNumber;
//    }
//
//    public void setLineNumber(int lineNumber) {
//        this.lineNumber = lineNumber;
//    }
//
//    public String myReadLine() throws IOException {
//        lineNumber++;
//        StringBuilder sb = new StringBuilder();
//
//        int ch = 0;
//
//        while ((ch = r.read()) != -1){
//            if (ch == '\r'){
//                continue;
//            }
//            if (ch =='\n'){
//                return sb.toString();
//            }
//            else
//                sb.append((char)ch);
//        }
//        if (sb.length() != 0)
//            return sb.toString();
//        return null;
//    }
//    public void myClose() throws IOException {
//        r.close();
//    }
//}

public class MyLineNumberReaderDemo {
    public static void main(String args[]) throws IOException {

        FileReader fr = new FileReader("bufWriter_copy.txt");
        MyLineNumberReader mylnr = new MyLineNumberReader(fr);

        String line = null;

        //// TODO:打印行号错误
        while ((line = mylnr.myReadLine()) != null){
            System.out.println(mylnr.getLineNumber()+"："+line);
        }

        mylnr.myClose();
    }
}
