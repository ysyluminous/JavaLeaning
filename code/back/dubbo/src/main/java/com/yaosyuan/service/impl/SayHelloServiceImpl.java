/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午1:17:40
*/
package com.yaosyuan.service.impl;

import com.yaosyuan.service.SayHelloService;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午1:17:40
 */
public class SayHelloServiceImpl implements SayHelloService {

	/**
	 * (非 Javadoc) Title: sayHello Description:
	 * 
	 * @param name
	 * @return
	 * @see com.yaosyuan.service.SayHelloService#sayHello(java.lang.String)
	 */
	public String sayHello(String name) {
		return "hello" + name;
	}

}
