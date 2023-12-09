<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update book</title>
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
        <form action="/books/update" method="post">
            <tr>
                <td> ${book.id} </td>
                <td>
                    <label>
                        <input type="text" name="bookName" placeholder="${book.bookName}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="author" placeholder="${book.author}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="yearOfPublishing" placeholder="${book.yearOfPublishing}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="publishingHouse" placeholder="${book.publishingHouse}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="annotation" placeholder="${book.annotation}">
                    </label>
                </td>
                <td>
                    <label>
                        <input type="text" name="price" placeholder="${book.price}">
                    </label>
                </td>
                <td>${book.dateTime}</td>
                <td>
                    <input type="submit" value="UPDATE">
                    <input type="hidden" name="id" value="${book.id}">
                </td>
                <a href="/books/read"><p>CANCEL</p></a>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
