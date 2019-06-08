/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午3:17:42
*/
package com.yaosyuan.test;

/**
 * @description: 功能描述 (使用4个子线程求出1到100的和并答应。每个子线程计算25个数)
 * @copyright: Copyright (c) 2019
 * @company: yaosiyaun
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午3:17:42
 */
public class FourThread {

	// 12213321

	/*
	 * CREATE TABLE `student` ( `name` varchar(50) DEFAULT NULL COMMENT '姓名',
	 * `age` int(11) DEFAULT NULL COMMENT '年龄', `birthday` varchar(50) DEFAULT
	 * NULL COMMENT '出生日期' ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	 */

	static int sum11 = 0;
	static int sum12 = 0;
	static int sum13 = 0;
	static int sum14 = 0;
	static int sum = 0;

	public static void main(String[] args) throws InterruptedException {
		new Thread() {
			public void run() {
				int sum1 = 0;
				for (int i = 1; i <= 25; i++) {
					sum1 += i;
				}
				sum11 += sum1;
			}
		}.start();

		new Thread() {
			public void run() {

				int sum2 = 0;
				for (int i = 26; i <= 50; i++) {
					sum2 += i;
				}
				sum12 += sum2;
			}
		}.start();

		new Thread() {
			public void run() {

				int sum3 = 0;
				for (int i = 51; i <= 75; i++) {
					sum3 += i;
				}
				sum13 += sum3;
			}
		}.start();

		new Thread() {
			public void run() {
				int sum4 = 0;
				for (int i = 76; i <= 100; i++) {
					sum4 += i;
				}
				sum14 = sum4;
			}
		}.start();

		Thread.sleep(100);

		sum = sum11 + sum12 + sum13 + sum14;
		System.out.println("sum: " + sum);
	}

}
