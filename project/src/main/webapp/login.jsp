<%--
  Created by IntelliJ IDEA.
  User: wayaya
  Date: 14-4-23
  Time: 下午9:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String expr = request.getParameter("expr");
    System.out.println(expr);
%>
<%=expr%>

</body>
</html>
