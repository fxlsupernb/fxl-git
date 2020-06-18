<%--
  Created by IntelliJ IDEA.
  User: fanxinglong
  Date: 2020-06-17
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>show</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>图片</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pictures}" var="pic">
            <tr>
                <td><img src="files/${pic.path}" width="100"></td>
                <td><a href="delete?id=${pic.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
<form action="/insert" method="post" enctype="multipart/form-data">
    广告图片：<input type="file" name="file"/><br/>
    <input type="submit" value="提交"/><br/>
</form>
</body>
</html>
