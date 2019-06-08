/***********************************************************************
 *
 * 文件名:	DuoTaiDemo5
 *
 * 文件描述:	第14天_02_集合框架_共性方法
 *
 * 创建人:	Yao Siyuan,
 *
 * 总结:
 *
 * 版本号:	0.1
 *
 * 修改记录:
 *			0.1:
 *
 ************************************************************************/
package day_14;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Yao Siyuan on 2016/7/17/017.
 */
public class CollectionDemo {
    public static void main(String [] args)
    {
        //创建一个集合容器，使用Collection接口的子类，ArrayList
        ArrayList a1 = new ArrayList();

        //1,添加元素
        a1.add("java01");
        a1.add("java02");
        a1.add("java03");
        a1.add("java04");

        //2，获取长度，集合长度
        sop("size = "+a1.size());
    }
    public static void sop(Object obj)
    {
        System.out.println(obj);
    }
}
