package bxd_day19;

import java.io.IOException;
import java.io.InputStream;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.12.03
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class MyBufferedInputStream {
    private InputStream in;

    private byte [] buf = new byte[1024*4];

    private int pos = 0,count = 0;
    MyBufferedInputStream(InputStream in){
        this.in = in;
    }

//   一次读一个字节，从缓冲区(字节数组)获取
    public int myRead() throws IOException {
        //通过in对象读取硬盘上的数据，并存储buf中。

        if (count == 0) {
            count = in.read(buf);
                if (count < 0){
                    return -1;
                }
            pos = 0;

            byte b = buf[pos];

            count--;
            pos++;
            return b&255;
        }
        else if (count > 0){
            byte b = buf[pos];

            count--;
            pos++;

            //转换提升 补0 避免 -1 的情况
            return b&0xff;
        }
        return -1;
    }

    public void MyClose() throws IOException {
        in.close();
    }
}


/*
*   read在补0提升
*   write在强转、吧最低的8位写出去，剩下的砍掉，只写最低的字节。
*   保证数据不变。
*
*   10100000100000011110010100010010010001001010101
*
*   byte : -1  ----> int : -1
*
*   00000000 - 00000000 - 00000000 - 11111111  255
*   11111111 - 11111111 - 11111111 - 11111111
*
*       11111111 - 11111111 - 11111111 - 11111111
*       00000000 - 00000000 - 00000000 - 11111111
*   --------------------------------------------------
*       00000000 - 00000000 - 00000000 - 11111111

*   提升了一个int类型，那不还是-1么？是-1的原因是因为在8个1的前面补的是1导致的
*   那么我只要在前面补0，既可以保留原字节数据不变。又可以避免-1的出现。
*   那怎么补0呢？
*
*
* */