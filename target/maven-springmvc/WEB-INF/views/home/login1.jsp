<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/10/21
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Login1</title>
    <script  type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-3.2.1.min.js"> </script>
</head>
<body>
<h1>这是通过model方式返回的页面</h1>
${user.loginname}
</body>
</html>
