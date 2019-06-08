<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/10/2017
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = (String)request.getAttribute("msg");
    if(msg!=null)
        out.print(msg);
%>


<form action="/dologin" method="post">
    用户名：<input type="text" name="userName"/><br/>
    密码：<input type="password" name="pwd"/><br/>
    <input type="submit" value="登录"/><br/>
</form>

    <%--<%--%>
        <%--//获取表单数据--%>
        <%--String userName = request.getParameter("userName");--%>
        <%--String pwd = request.getParameter("pwd");--%>
        <%--//处理业务逻辑--%>
        <%--if ("tom".equals(userName) && "123".equals(pwd)){--%>
            <%--//转发--%>
<%--//            request.getRequestDispatcher("/success.jsp").forward(request,response);--%>
            <%--response.sendRedirect("/success.jsp");--%>

        <%--}else {--%>
            <%--response.sendRedirect("/login.jsp");--%>
        <%--}--%>
    <%--%>--%>



</body>
</html>















