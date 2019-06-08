/**
 * 
 */
package com.ysy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建cookie的案例
 * 
 * @author yaosiyuan
 *
 */

@WebServlet("/addCookie")
public class AddCookieServlet extends HttpServlet {
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// key value
		Cookie cookie = new Cookie("userName", "1231");
		cookie.setMaxAge(60 * 60 * 24);// cookie保存一天，没有一家公司能做到永久保存。

		// 将cookie发送到cookie
		resp.addCookie(cookie);
	}
}
