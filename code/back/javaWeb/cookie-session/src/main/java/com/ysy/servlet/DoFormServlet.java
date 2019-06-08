/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午4:16:16
*/
package com.ysy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * @description: TODO (表单servlet)
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午4:16:16
 */
@WebServlet("/DoFormServlet")
public class DoFormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		if (!isSubmit(req)) {
			System.out.println("你已经提交了数据，或者tokenu错误");
			resp.getWriter().write("你已经提交了数据，或者tokenu错误");
		}
		String userName = req.getParameter("userName");
		try {
			Thread.sleep(300);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("往数据库插入数据...." + userName);
		resp.getWriter().write("保存成功");
		req.getSession().removeAttribute("sessionToken");
	}

	public Boolean isSubmit(HttpServletRequest request) {
		String parameter = request.getParameter("parameterToken");
		Session sessionToken = (Session) request.getSession().getAttribute("sessionToken");
		// 判断是否提交
		if (sessionToken == null) {
			return false;

		}

		// 判断是否是伪造token
		if (!(parameter.equals(sessionToken))) {
			return false;
		}
		return true;
	}

}
