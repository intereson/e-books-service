<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Are you shore? Delete user?</title>
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
        <form action="/users/delete" method="post">
            <tr>
                <td> ${user.id} </td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.mail}</td>
                <td>${user.userType}</td>
                <td>${user.login}</td>
                <td><a href="/user/shoppingCart">
                    <p>Shopping Cart</p>
                    <input type="hidden" name="id" value="${user.shoppingCart.id}">
                </a>
                </td>
                <td>${user.dateTime}</td>
                <td>
                    <input type="submit" value="DELETE">
                </td>
                <a href="/users/read">  <p>CANCEL</p> </a>
            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
