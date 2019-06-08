/**
 * 
 */
package com.ysy.session;

/**
 * 缓存实体类
 * 
 * 
 * @author yaosiyuan
 *
 */
public class Cache {
	// key
	private String key;

	// 值
	private Object value;
	// 有效期
	private Long timeout;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * @return the timeout
	 */
	public Long getTimeout() {
		return timeout;
	}

	/**
	 * @param timeout
	 *            the timeout to set
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

}
