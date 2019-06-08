package com.yaosiyuan.ehcache;


/**
 * @Author YaoSiyuan
 * @Description 缓存测试借口类
 * @Date 16:24 2019/5/19
 * @Param
 * @return
 **/
public interface EhcacheService {
    // 测试失效情况，有效期为5秒
    public String getTimestamp(String param);
    public String getDataFromDB(String key);
    public void removeDataAtDB(String key);
    public String refreshData(String key);
    public User findById(String userId);
    public boolean isReserved(String userId);
    public void removeUser(String userId);
    public void removeAllUser();
}
