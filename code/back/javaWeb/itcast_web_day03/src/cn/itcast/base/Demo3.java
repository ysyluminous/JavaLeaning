package cn.itcast.base;
import org.junit.Test;;
import java.util.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.20
 *
 * Summary:	增强for循环
 * 设计的本意：抛弃迭代器
 * 增强For循环只能用在数组或是实现了Iterable接口的子类上。
 * 格式：
 * for(元素的类型 变量名: 数组或是先了Iteratable接口的对象)
 *  System.out.println(变量名);
 *
 *  增强for循环的特点，只适合取数据，要想在遍历时更改元素的值，请使用传统for循环
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Demo3 {
    @Test
    public void test1(){
        String s[] = {"a","b","c","d"};
        /*for (int i = 0; i < s.length; i++){
            System.out.print(s[i]);
        }*/

        for(String ss:s){
            System.out.println(ss);
    }

    }
    @Test
    public void test2(){
        List l = new ArrayList();
        l.add("aaa");
        l.add("bbb");
        l.add("ccc");
        l.add("ddd");

      /*  Iterator it = l.iterator();
        while (it.hasNext()){
            String s = (String)it.next();
            System.out.println(s);
        }*/


        for (Object obj:l){
            String s = (String)obj;
            System.out.println(s);
//            System.out.println(obj);
        }
    }
    //传统方式遍历Ma
        @Test
        public void test3(){
            Map map = new LinkedHashMap();
            map.put("a","aaa");
            map.put("b","bbb");
            map.put("c","ccc");

            Set keys = map.keySet();
            Iterator it = keys.iterator();
            while (it.hasNext()){
                String key = (String)it.next();
                String value =(String)map.get(key);
                System.out.println(key+"="+value);
            }
        }
    @Test //增强for遍历map方式一
    public void test31(){
        Map map = new LinkedHashMap();
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("c","ccc");

        Set keys = map.keySet();
        for (Object obj : keys){
            String key = (String) obj;
            String value = (String) map.get(key);
            System.out.println(key+"="+value);

        }

    }

    @Test
    public void test4(){
        Map map = new LinkedHashMap();
        map.put("a","aaa");
        map.put("d","ddd");
        map.put("c","ccc");
        map.put("e","eee");

        Set me = map.entrySet();
        Iterator it = me.iterator();
        while (it.hasNext()){
            Map.Entry m = (Map.Entry)it.next();
            String key = (String) m.getKey();
            String value = (String) m.getValue();
            System.out.println(key + "=" + value);
        }

    }


    @Test
    public void test41(){
        Map map = new LinkedHashMap();
        map.put("a","aaa");
        map.put("d","ddd");
        map.put("c","ccc");
        map.put("e","eee");

        for (Object obj : map.entrySet()){
            Map.Entry me = (Map.Entry) obj;
            String key = (String) me.getKey();
            String value = (String) me.getValue();
            System.out.println(key + "=" + value);
        }

    }

    @Test
    public void test5(){
        int arr[] = {1,1,1,1};
//        for (int i : arr){
//            i = 10;
//        }
        //循环时更改元素的值必须使用传统方式
        for (int i = 0;i< arr.length;i++){
            arr[i] = 100;
        }
        System.out.println(arr[0]);
    }
    @Test
    public void test6(){
        List list = new ArrayList();
        list.add("p");
        for (Object obj:list){
            obj="ppp";
        }
        System.out.println(list.get(0));
    }



}
