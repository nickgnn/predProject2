<%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 25.09.2019
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p><a href="/">Main</a></p>

<form action="/users" method="get">
    <table>
            <tbody>
            <tr>
                <td>Login:</td>
                <td>
                    <input type="text" name="user">
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password" name="pass">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Enter">
                </td>
            </tr>
            </tbody>
        </table>
</form>
</body>
</html>
