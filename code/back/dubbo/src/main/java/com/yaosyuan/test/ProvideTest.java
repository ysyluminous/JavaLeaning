/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午1:27:16
*/
package com.yaosyuan.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午1:27:16
 */
public class ProvideTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "application-context-provide.xml" });
		// 启动spring容器
		context.start();
		// 等待输入不让系统听
		System.in.read();
	}

}
