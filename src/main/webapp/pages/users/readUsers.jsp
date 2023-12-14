<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<form action="<c:url value="/exit"/>">
    <input type="submit" value="EXIT">
</form>
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
    <jsp:useBean id="users" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${users}">
        <tr>
            <td> ${user.id} </td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.mail}</td>
            <td>${user.userType}</td>
            <td>${user.login}</td>
            <td><a href="/user/shoppingCart">
                <p>Shopping Cart</p>
                <input type="hidden" name="id" value="${user.shoppingCart.idShoppingCart}">
            </a>
            </td>
            <td>${user.dateTime}</td>
            <td>
                <form action="<c:url value="/users/delete"/>" method="get">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
    <form action="<c:url value="/books/read"/>">
        <input type="submit" value="Books">
    </form>

    </tbody>
</table>
</body>
