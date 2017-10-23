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

<div style="padding: 20px">
    <form action="/upload/uploadpic" enctype="multipart/form-data" method="post" mu>
    <table>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${items.pic !=null}">
                    <img src="/pic/${items.pic}" width=100 height=100/>
                    <br/>
                </c:if>
                <input type="file"  name="items_pic"/>
            </td>
        </tr>
    </table>
    </form>
</div>

<h1>使用springMVC上传图片</h1>

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

</body>
</html>
