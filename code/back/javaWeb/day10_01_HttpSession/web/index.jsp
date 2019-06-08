<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/10/2017
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <%
        String msg = (String) request.getAttribute("msg");
        if (msg!= null){
          out.print(msg);
        }

      %>


      <form action="/dologin" method="post">
        用户名：<input type="text" name="userName"/><br>
        密码：<input type="password" name="pwd"/><br>
        验证码：<input type="text" name="code"/>
        <img src="/codeServlet" onclick="changeCode()"/><a href="javascript:changeCode()" >看不清换一张</a><br>
        <input type="submit" value="登录"/><br>
      </form>

  </body>
</html>
