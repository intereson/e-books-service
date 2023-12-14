<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create book</title>
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
                    <input type="number" name="yearOfPublishing" placeholder="put year of publishing">
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
                <label>Price</label>
                    <input type="number" name="price_int" placeholder="put price book">
                    <input type="number" name="price_frac" min="1" max="99">
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