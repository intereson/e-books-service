<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete book</title>
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
        <th>Date Registration</th>
    </tr>
    </thead>
    <tbody>
    <form action="<c:url value="/books/create"/>" method="post">
        <tr>
            <td>
                <label>
                    <input type="text" name="bookName" placeholder="put name book">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="author" placeholder="put author book">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="yearOfPublishing" placeholder="put year of publishing">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="publishingHouse" placeholder="put publishing house">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="annotation" placeholder="put annotation book">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="price" placeholder="put price book">
                </label>
            </td>
            <td>
                <input type="submit" value="CREATE">
            </td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>