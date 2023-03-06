<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/3/2023
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Painting</title>
</head>
<body>
<h1>Painting details</h1>
<p>
    <a href="/paintings">Back to painting list</a>
</p>
<table>
    <tr>
        <td>Paint Code:</td>
        <td>${requestScope["painting"].getPaintCode()}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${requestScope["painting"].getName()}</td>
    </tr>
    <tr>
        <td>Height:</td>
        <td>${requestScope["painting"].getHeight()}</td>
    </tr>
    <tr>
        <td>Width:</td>
        <td>${requestScope["painting"].getWidth()}</td>
    </tr>
    <tr>
        <td>Material:</td>
        <td>${requestScope["painting"].getMaterial()}</td>
    </tr>
    <tr>
        <td>Status:</td>
        <td>${requestScope["painting"].getStatus()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope["painting"].getPrice()}</td>
    </tr>
</table>
</body>
</html>