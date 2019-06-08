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

import com.yaosyuan.service.SayHelloService;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午1:27:16
 */
public class ConsumerTest {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "application-context-consumer.xml" });
		context.start();
		SayHelloService sayHello = (SayHelloService) context.getBean("sayHello1");

		String hello = sayHello.sayHello("YaoSiyuan");
		// press any key to exit
		System.out.println(hello);
		System.in.read();
	}

}
