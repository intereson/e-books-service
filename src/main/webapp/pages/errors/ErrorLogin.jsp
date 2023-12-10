<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<p>Error Login</p>
<p>The entered login or email already exists</p>
<p>Try again</p>
<a href="<c:url value="/users/authentication"/>">
  <p>Enter</p>
</a>
<a href="<c:url value="/users/registration"/>">
    <p>Registration</p>
</a>
</body>
</html>
