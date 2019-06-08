<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/10/2017
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎你:<%
    String userName = (String) session.getAttribute("name");
    out.print(userName);
%>

<a href="/home.jsp">跳到主页</a>



</body>
</html>
