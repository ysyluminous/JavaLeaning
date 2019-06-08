package com.yaosiyuan;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @Author YaoSiyuan
 * @Description 测试类
 * @Date 22:54 2019/5/18
 * @Param
 * @return
 **/
public class CacheTest {
    public static void main(String[] args) {
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");
        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");
        // 3. 创建元素
        Element element = new Element("key1", "value1");
        // 4. 将元素添加到缓存
        cache.put(element);
        // 5. 获取缓存
        Element value = cache.get("key1");
//        System.out.println(value);
//        System.out.println(value.getObjectValue());

        Person person = new Person();
        person.setId(1);
        person.setName("yaosiyuan");



        //测试是否可用
//        Element testvalue1 = cache.get("person1");
//        Person testperson2 = (Person) testvalue1.getObjectValue();
//        System.out.println(testperson2);




        Element  element1 = new Element("person1",person);
        cache.put(element1);
        Element value1 = cache.get("person1");
        Person person2 = (Person) value1.getObjectValue();
        System.out.println(person2);

        // 7. 刷新缓存
        cache.flush();
        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }
}

