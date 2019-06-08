<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            List list = new ArrayList();
            out.print(list.size());
//            list.add("aaa");
//            list.add("bbb");
//            list.add("ccc");
//            list.add("ddd");

            request.setAttribute("list",list);



            Map map = new HashMap();
            map.put("a","aaa");
            map.put("b","bbb");
            map.put("c","ccc");
            map.put("d","ddd");
            map.put("e","eee");

            request.setAttribute("m",map);

        %>

        ${list[1]}<br>
        <%--${m[["b"]}--%>
        ${m.c}

</body>
</html>














