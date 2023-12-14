<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<p>Error Data</p>
<a href="<c:url value="/books/read"/>">
    <p>EXIT</p>
</a>
<form action="<c:url value="/books/read"/>" method="get">
        <input type="submit" value="Try again">
</form>
</body>
</html>
