<%--
  Created by IntelliJ IDEA.
  User: anlu
  Date: 2017/10/23
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传图片</title>
</head>
<body>



<h1>用最简单方式->使用springMVC上传图片</h1>

<form action="/upload/springUpload" enctype="multipart/form-data" method="post">
    文件描述:
    <input type="text" name="description">



    <input type="file"  name="file"/>

    <input type="submit" value="上传">
</form>

<h2>${item}</h2>
<c:if test="${picurl !=null}">
    <img src="/pic/${picurl}" width=200 height=200/>
    <br/>
</c:if>

<h2>用对象的方式上传图片</h2>
<h2>用户注册</h2>
<form action="/upload/uploadObj" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>请上传头像:</td>
            <td><input type="file" name="image"></td>
            <c:if test="${user.imgUrl !=null}">
                <img src="/pic/${user.imgUrl}" width=200 height=200/>
                <br/>
            </c:if>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>


</body>
</html>
