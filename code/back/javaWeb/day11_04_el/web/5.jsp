<%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 1/11/2017
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%


    //            pageContext.setAttribute("p","pp");
             pageContext.setAttribute("p","pp",pageContext.PAGE_SCOPE);

//            pageContext.setAttribute("p","pp",pageContext.REQUEST_SCOPE);
            request.setAttribute("p","request");

//            pageContext.setAttribute("p","pp",pageContext.SESSION_SCOPE);
            request.setAttribute("p","session");

//        pageContext.setAttribute("p","pp",pageContext.SESSION_SCOPE);
             request.setAttribute("p","application");

//            request.getRequestDispatcher("2.jsp").forward(request,response);

        response.sendRedirect(request.getContextPath()+"/2.jsp");
%>

    <%--${p}--%>
</body>
</html>
