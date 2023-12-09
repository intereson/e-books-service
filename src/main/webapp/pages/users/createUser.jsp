<html>
<head>
    <title>Create new user</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Family</th>
        <th>Email</th>
        <th>Login</th>
        <th>Password</th>

    </tr>
    </thead>
    <tbody>
    <form action="/users/create" method="post">
        <tr>
            <td>
                <label>
                    <input type="text" name="name" placeholder="put your mame">
                </label>
            </td>
            <td>
                <label>
                    <input type="text" name="surname" placeholder="put your family">
                </label>
            </td>
            <td>
                <label>
                    <input type="email" name="mail" placeholder="put your email">
                </label>
            </td><td>
                <label>
                    <input type="text" name="login" placeholder="put your login">
                </label></td><td>
                <label>
                    <input type="password" name="password" placeholder="put your password"  maxlength="16">
                </label>
        </td>
                <input type="submit" value="CREATE">
            </td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
