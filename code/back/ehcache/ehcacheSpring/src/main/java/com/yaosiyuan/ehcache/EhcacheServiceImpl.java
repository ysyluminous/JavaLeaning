package com.yaosiyuan.ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;



@Service
public class EhcacheServiceImpl implements EhcacheService{
    /**
     * @Author YaoSiyuan
     * @Description value的值和ehcache.xml中的配置保持一致
     * key为参数
     * @Date 16:27 2019/5/19
     * @Param [param]
     * @return java.lang.String
     **/
    @Cacheable(value="HelloWorldCache", key="#param")
    @Override
    public String getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }




    @Cacheable(value="HelloWorldCache", key="#key")
    @Override
    public String getDataFromDB(String key) {
        System.out.println("从数据库中获取数据...");
        return key + ":" + String.valueOf(Math.round(Math.random()*1000000));
    }




    @CacheEvict(value="HelloWorldCache", key="#key")
    @Override
    public void removeDataAtDB(String key) {
        System.out.println("从数据库中删除数据");
    }
    @CachePut(value="HelloWorldCache", key="#key")
    @Override
    public String refreshData(String key) {
        System.out.println("模拟从数据库中加载数据");
        return key + "::" + String.valueOf(Math.round(Math.random()*1000000));
    }




    @Override
    @Cacheable(value="UserCache", key="'user:' + #userId")
    public User findById(String userId) {  
        System.out.println("模拟从数据库中查询数据");
        return  new User(1, "mengdee");
    }


    /**
     * @Author YaoSiyuan
     * @Description condition缓存条件
     * userId如果小于12就请求缓存
     * @Date 16:28 2019/5/19
     * @Param [userId]
     * @return boolean
     **/
    @Override
    @Cacheable(value="UserCache", condition="#userId.length()<12")
    public boolean isReserved(String userId) {    
        System.out.println("UserCache:"+userId);    
        return false;    
    }


    /**
     * @Author YaoSiyuan
     * @Description   清除掉UserCache中某个指定key的缓存
     * @Date 16:29 2019/5/19
     * @Param [userId]
     * @return void
     **/
    @Override
    @CacheEvict(value="UserCache",key="'user:' + #userId")
    public void removeUser(String userId) {    
        System.out.println("UserCache remove:"+ userId);    
    }    



    /**
     * @Author YaoSiyuan
     * @Description 清除掉UserCache中全部的缓存
     * @Date 16:29 2019/5/19
     * @Param []
     * @return void
     **/
    @Override
    @CacheEvict(value="UserCache", allEntries=true)
    public void removeAllUser() {    
       System.out.println("UserCache delete all");    
    }
}

