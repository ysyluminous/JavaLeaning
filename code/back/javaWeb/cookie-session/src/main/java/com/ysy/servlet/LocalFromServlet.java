/**
 * @description: 功能描述：()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author: 
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午5:14:12
*/
package com.ysy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: 功能描述 ()
 * @copyright: Copyright (c) 2019
 * @company: 昭阳科技
 * @author:
 * @version: 2.0
 * @date: 2019 2019年3月2日 下午5:14:12
 */
@WebServlet("/local")
public class LocalFromServlet extends HttpServlet {

	/**
	 * (非 Javadoc) Title: doGet Description: 跳转到from.jsp
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 生成Token
		String token = TokenUtils.getToken();
		HttpSession session = req.getSession();
		session.setAttribute("sessionToken", token);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
