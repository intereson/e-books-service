<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Access</th>
        <th>Login</th>
        <th>Shopping Cart</th>
        <th>Date Registration</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td> ${user.id} </td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.mail}</td>
            <td>${user.userType}</td>
            <td>${user.login}</td>
            <td><a href="/user/shoppingCart"   >
                <p>Shopping Cart</p>
                <input type="hidden" name="id" value="${user.shoppingCart.id}">
            </a>
            </td>
            <td>${user.dateTime}</td>
            <td>
                <form action="/users/update" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Update" style="float:left">
                </form>
                <form action="/users/delete" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
    <form action="/users/create">
        <input type="submit" value="Add new User">
    </form>
    <form action="/books/read">
        <input type="submit" value="Books">
    </form>
    </tbody>
</table>
</body>
