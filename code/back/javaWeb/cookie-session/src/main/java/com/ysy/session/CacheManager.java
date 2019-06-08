
package com.ysy.session;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 提供缓存api
 * 
 * @author yaosiyuan
 *
 */
public class CacheManager {
	private Map<String, Cache> cacheMap = new HashMap<String, Cache>();

	/**
	 * 
	 * @description: TODO (添加session)
	 * @author: yaosiyuan
	 * @version: 2.0
	 * @date: 2019 2019年3月2日 下午1:10:23
	 * @param key
	 * @param value
	 */
	public synchronized void put(String key, Object value) {
		put(key, value, null);
	}

	/**
	 * 
	 * @description: TODO ()
	 * @author: yaosiyuan
	 * @version: 2.0
	 * @date: 2019 2019年3月2日 下午1:10:05
	 * @param key
	 * @param value
	 * @param timeout
	 */
	public synchronized void put(String key, Object value, Long timeout) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setValue(value);
		if (timeout != null) {
			cache.setTimeout(System.currentTimeMillis() + timeout);
		}
		cacheMap.put(key, cache);
	}

	public synchronized void del(String key) {
		cacheMap.remove(key);

	}

	/**
	 * 
	 * @description: TODO (使用key查询缓存)
	 * @author: yaosiyuan
	 * @version: 2.0
	 * @date: 2019 2019年3月2日 下午1:02:58
	 * @param key
	 * @return
	 */
	public synchronized Object get(String key) {
		Cache cache = cacheMap.get(key);
		if (cache != null) {
			return cache.getValue();
		}
		return null;
	}

	public synchronized void remove(String key) {
		System.out.println("key:" + key + "删除成功");
		cacheMap.remove(key);

	}

	/**
	 * 
	 * @description: TODO (定时检查删除)
	 * @author: yaosiyuan
	 * @version: 2.0
	 * @date: 2019 2019年3月2日 下午1:20:42
	 */
	public synchronized void checkValidityData() {
		for (String key : cacheMap.keySet()) {
			Cache cache = cacheMap.get(key);
			if (cache == null) {
				break;
			}

			// 毫秒数
			Long timeout = cache.getTimeout();
			Long currentTimeMillis = System.currentTimeMillis();
			// 说明已经过期
			if ((currentTimeMillis - timeout) > 0) {
				remove(key);
			}
		}
	}

	/**
	 * 
	 *
	 * @description: TODO (主函数)
	 * @author: yaosiyuan
	 * @version: 2.0
	 * @date: 2019 2019年3月2日 下午1:09:38
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		final CacheManager cacheManager = new CacheManager();
		cacheManager.put("userName", "123", 5000l);
		System.out.println("保存成功");
		// 定期检查刷新数据
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.schedule(new Runnable() {
			public void run() {
				cacheManager.checkValidityData();
			}
		}, 5000, TimeUnit.MILLISECONDS);

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}

		String userName = (String) cacheManager.get("userName");
		System.out.println("username:" + userName);
		// 开启一个线程，检查有效期
	}

}
