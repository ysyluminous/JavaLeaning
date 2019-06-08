<%@ page import="com.itheima.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            Student stu = new Student(address);
            stu.setName("tom");

            request.setAttribute("s",stu);
            request.getRequestDispatcher("/2.jsp").forward(request,response);
        %>
</body>
</html>











