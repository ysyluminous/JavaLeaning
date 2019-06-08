package bxd_day19;

import java.io.IOException;
import java.io.InputStream;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page
 *
 * @author Yao Siyuan 16.12.04
 *
 * Summary:	读取键盘录入
 *          System.out:对应的是标准输出设备，控制台
 *          System.in：对应的是标准输入设备，
 *
 *          需求：
 *          通过键盘录入数据。
 *          当录入一行数据后，就将该数据进行打印，如果录入的是over，那么停止录入。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class ReadIn {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;

//        System.out.println('\r'+0);
//        System.out.println('\n'+0);
//        int ch = 0;

        //可变长的缓冲
        StringBuilder sb = new StringBuilder();

        while (true){
            int ch = in.read();
            if (ch  == '\r')
                continue;
            if (ch == '\n'){
                String s = sb.toString();
                if ("over".equals(s))
                    break;
                System.out.println(s.toUpperCase());
                sb.delete(0,sb.length());
            }
            else
                sb.append((char)ch);
        }


//        while ((ch = in.read()) != -1){
//            System.out.println(ch);
//
//        }

        //阻塞方法。等待录入
//        int by = in.read();
//        int by1 = in.read();
//        int by2 = in.read();
//
//        System.out.println(by);
//        System.out.println(by1);
//        System.out.println(by2);

    }
}
