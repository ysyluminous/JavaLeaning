package com.yaosyuan.test;

import java.util.Scanner;

/**
 * @description: 功能描述 ( 计算一个航班的飞行时间，通过键盘输入两个数， 分别代表航班起飞时间和到达时间（不用考虑跨天的情况）。
 *               比如一个航班起飞是7:30，到达是14:20，则输入730和1420，
 *               通过程序，则要求输出内容为：“航班飞行时间为6小时50分钟”。 )
 * @copyright: Copyright (c) 2019
 * @company:
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月15日 下午3:13:23
 */
public class OutPutPlanInfo {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			// 输入两个数
			Integer i = scanner.nextInt();
			Integer j = scanner.nextInt();
			// 小时
			Integer h1 = i / 100;
			Integer h2 = j / 100;
			// 分钟
			Integer m1 = i % 100;
			Integer m2 = j % 100;
			// 判断分钟差是否小于0
			if (m2 - m1 < 0) {
				Integer h = h2 - h1 - 1;
				Integer m = m2 - m1 + 60;
				System.out.println("航班飞行时间为" + h + "小时" + m + "分钟");
				// 直接输出
			} else {
				Integer h = h2 - h1;
				Integer m = m2 - m1;
				System.out.println("航班飞行时间为" + h + "小时" + m + "分钟");
			}
			// 捕获异常
		} catch (Exception e) {
			System.out.println("您的输入有误，请检查！");
		}
	}

}
