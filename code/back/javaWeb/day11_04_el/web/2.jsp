<%@ page import="com.itheima.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Student stu = (Student) request.getAttribute("s");
//        out.print(s);
        out.print(stu.getName());
    %>

    ${s}    <!--${s}== page.Context.findAttribute("s") - -->
    ${s.city.address}    <!--${s}== page.Context.findAttribute("s") - -->
</body>
</html>












