/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午8:55:51
*/
package com.yaosiyuan.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年5月2日 下午8:55:51
 */
@Controller
@RequestMapping("hello")
public class HelloController {

	@RequestMapping("test")
	public void hello(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		try {
			PrintWriter writer = response.getWriter();
			writer.println("hello==" + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
