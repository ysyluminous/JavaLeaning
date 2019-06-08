package com.itheima.servlet;

import cn.dsna.util.images.ValidateCode;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "CodeServlet",urlPatterns = {"/codeServlet"})
public class CodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ValidateCode vc = new ValidateCode(110,25,4,7);
        //向session中保存验证码
        request.getSession().setAttribute("scode",vc.getCode());
        vc.write(response.getOutputStream());
    }
}






