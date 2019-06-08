<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reg</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/regservlet" method="post">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="password" name="password"><br/>
        确认密码：<input type="password" name="repassword"><br/>
        邮箱：<input type="text" name="email"><br/>
        生日：<input type="text" name="birthday"><br/>
            <input type="submit" value="注册"><br>


    </form>
</body>
</html>
