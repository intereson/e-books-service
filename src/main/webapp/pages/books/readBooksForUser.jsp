<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Books</title>
</head>
<body>

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
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.publishingHouse}</td>
            <td>${book.annotation}</td>
            <td>${book.price}</td>
            <td>
                <form action="/books" method="get">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Put in cart">
                </form>
            </td>
        </tr>
    </c:forEach>
        </tbody>
</table>
</body>
