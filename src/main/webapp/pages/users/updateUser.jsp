<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="users" scope="request" type="java.util.List"/>
    <c:forEach var="user" items="${users}">
        <form action="<c:url value="/users/update"/>" method="post">
            <tr>
                <td>
                    <label>
                        <input type="text" name="name" placeholder="${user.name}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="surname" placeholder="${user.surname}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="email" name="mail" placeholder="${user.mail}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="login" placeholder="${user.login}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="password">
                    </label>
                </td><td>
                <input type="submit" value="UPDATE">
                <input type="hidden" name="id" value="${user.id}">
                </td>
                <a href="<c:url value="/users/read"/>"><p>CANCEL</p></a>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
