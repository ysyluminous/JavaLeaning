/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午5:18:24
*/
package com.ysy.servlet;

import java.util.UUID;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午5:18:24
 */
public class TokenUtils {
	static public String getToken() {
		return UUID.randomUUID().toString();
	}

	public static void main(String[] args) {
		System.out.println(TokenUtils.getToken());
	}
}
