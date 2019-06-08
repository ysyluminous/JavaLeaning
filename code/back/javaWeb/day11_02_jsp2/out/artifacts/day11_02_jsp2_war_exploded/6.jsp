<%@ page import="com.itmeiha.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            Student stu = new Student();
            stu.setName("tom");

            out.print(stu.getName());

//            request.getRequestDispatcher("7.jsp").forward(request,response);
        %>

        <jsp:useBean id="stu1" class="com.itmeiha.entity.Student"></jsp:useBean>
        <jsp:setProperty name="stu1" property="name" value="jerry"></jsp:setProperty>
        <jsp:getProperty name="stu1" property="name"></jsp:getProperty>

        <%--http://localhost:8080/6.jsp?name=123--%>
        <jsp:forward page="7.jsp">
            <jsp:param name="name" value="tom"></jsp:param>
            <jsp:param name="pwd" value="123"></jsp:param>
        </jsp:forward>
</body>
</html>










