<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/10/2017
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>欢迎来到本网站！</h1>
        <h1>欢迎来到本网站！</h1>
        欢迎你：<%
            /* String userName = request.getParameter("userName");
            out.print(userName); */
            String userName = (String)session.getAttribute("name");
            out.print(userName);
        %>
</body>
</html>
