<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:forward page="/main"/>
<html>

<head>
    <title>e-books-service</title>
</head>
<body>
<h1>The bookstore welcomes you</h1>
<form action="<c:url value="/main"/>" method="get">
    <input type="submit" value="Enter">
</form>
</body>
</html>