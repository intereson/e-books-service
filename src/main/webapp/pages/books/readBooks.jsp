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
        <th>Id</th>
        <th>Name</th>
        <th>Author</th>
        <th>Year Of Publishing</th>
        <th>Publishing House</th>
        <th>Annotation</th>
        <th>Price</th>
        <th>Date Registration</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="book" items="${books}">
        <tr>
            <td> ${book.id} </td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.yearOfPublishing}</td>
            <td>${book.publishingHouse}</td>
            <td>${book.annotation}</td>
            <td>${book.price}</td>
            <td>${book.dateTime}</td>
            <td>
                <form action="/books/update" method="get">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Update" style="float:left">
                </form>
                <form action="/books/delete" method="get">
                    <input type="hidden" name="id" value="${book.id}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
    <form action="/books/create">
        <input type="submit" value="Add new book">
    </form>
    <form action="/users/read">
        <input type="submit" value="Users">
    </form>
    </tbody>
</table>
</body>

