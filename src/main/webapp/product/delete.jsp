<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/03/2023
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Painting</title>
</head>
<body>
<h1>Delete Painting</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/paintings">Back to painting list</a>
</p>
<form method="post">
    <h3>Are you sure</h3>
    <fieldset>
        <legend>Painting information</legend>
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
            <tr>
                <td><input type="submit" value="Delete painting"></td>
                <td><a href="/paintings">Back to painting list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
