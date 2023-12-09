<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete book</title>
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
        <form action="/books/delete" method="post">
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
                    <input type="submit" value="DELETE">
                    <input type="hidden" name="id" value="${book.id}">
                </td>
                <a href="/books/read">  <p>CANCEL</p> </a>
            </tr>
        </form>
    </c:forEach>

    </tbody>
</table>
</body>
</html>