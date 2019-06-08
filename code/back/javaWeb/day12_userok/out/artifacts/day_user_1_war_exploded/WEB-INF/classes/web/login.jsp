<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/12/2017
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
${msg }
     <form action="${pageContext.request.contextPath}/servlet/login" method="post">
         用户名：<input type="text" name="username"/><br>
         密码：<input type="password" name="password"/><br>
         <input type="submit" value="登录"/><br/>
     </form>
</body>
</html>
