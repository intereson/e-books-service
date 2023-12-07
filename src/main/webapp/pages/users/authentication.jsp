<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/users/authentication" method="post">
        <tr>
            <td>
                <label>
                    <input type="text" name="login" placeholder="put your login">
                </label></td>
            <td>
                <label>
                    <input type="password" name="password" placeholder="put your password" minlength="8" maxlength="16">
                </label>
            </td>
            <td>
            <input type="submit" value="ENTER">
            </td>
        </tr>
    </form>
    </a>
    <a href="/users/registration">
        <p>Registration</p>
    </a>
    </tbody>
</table>
</body>
</html>
