<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Painting List</title>
</head>
<body>
<h1>Painting</h1>
<p>
    <a href="/paintings?action=create">Create new painting</a>
</p>
<table border="1">
    <tr>
        <td>Paint Code</td>
        <td>Name</td>
        <td>Height</td>
        <td>Width</td>
        <td>Material</td>
        <td>Status</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["painting"]}' var="painting">
        <tr>
            <td>${painting.getPaintCode()}</td>
            <td><a href="/paintings?action=view&id=${painting.getId()}">${painting.getName()}</a></td>
            <td>${painting.getHeight()}</td>
            <td>${painting.getWidth()}</td>
            <td>${painting.getMaterial()}</td>
            <td>${painting.getStatus()}</td>
            <td>${painting.getPrice()}</td>
            <td><a href="/paintings?action=edit&id=${painting.getId()}">edit</a></td>
            <td><a href="/paintings?action=delete&id=${painting.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
