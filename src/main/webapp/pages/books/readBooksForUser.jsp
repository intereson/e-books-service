<%@ page contentType="text/html;charset=UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<form action="<c:url value="/users/authentication"/>" method="get">
    <input type="submit" value="Enter">
</form>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Author</th>
        <th>Year Of Publishing</th>
        <th>Publishing House</th>
        <th>Annotation</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <jsp:useBean id="books" scope="request" type="java.util.List"/>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.publishingHouse}</td>
            <td>${book.annotation}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
