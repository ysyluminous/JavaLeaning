<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: yaosiyuan
  Date: 2/4/2017
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Context initContext = new InitialContext();
    DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/day13_03_JNDI");
    Connection conn = ds.getConnection();
    out.print(conn);
  %>
  </body>
</html>
