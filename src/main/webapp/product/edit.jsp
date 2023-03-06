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
    <title>Edit Painting</title>
</head>
<body>
<h1>Edit Painting</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/paintings">Back to painting list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Painting information</legend>
        <table>
            <tr>
                <td>Paint Code: </td>
                <td><input type="text" name="paintCode" id="paintCode"  value="${requestScope["painting"].getPaintCode()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"  value="${requestScope["painting"].getName()}"></td>
            </tr>
            <tr>
                <td>Height: </td>
                <td><input type="text" name="height" id="height"  value="${requestScope["painting"].getHeight()}"></td>
            </tr>
            <tr>
                <td>Width: </td>
                <td><input type="text" name="width" id="width"  value="${requestScope["painting"].getWidth()}"></td>
            </tr>
            <tr>
                <td>Material: </td>
                <td><input type="text" name="material" id="material" value="${requestScope["painting"].getMaterial()}"></td>
            </tr>
            <tr>
                <td>Status: </td>
                <td><input type="text" name="status" id="status" value="${requestScope["painting"].getStatus()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["painting"].getPrice()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update painting"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
