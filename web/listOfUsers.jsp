<%@ page import="java.util.List" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: nick
  Date: 28.09.2019
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<body>
<p><a href="/">Main</a></p>


<form action="/add" method="post">
    <table>
                <tbody>
                <%--<tr>--%>
                    <%--<td>ID:</td>--%>
                    <%--<td>--%>
                        <%--<input type="number" name="id">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <tr>
                    <td>Name:</td>
                    <td>
                        <input type="text" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>
                        <input type="number" name="age">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Add User">
                    </td>
                </tr>
                </tbody>
            </table>
</form>

<br><br>

<h1>Users</h1>
<form action="/users" method="post">
    <input type="submit" value="Refresh Users">
</form>


<table border="3">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Edit User</th>
            <th>Delete User</th>
        </tr>
    </thead>
    <%
        int i = 1;
        List<User> userList = (List<User>) request.getAttribute("usersList");
    %>
    <%
        for (User user : userList) {
    %>

    <tr>
        <th><%=user.getId()%></th>
        <th><%=user.getName()%></th>
        <th><%=user.getAge()%></th>
        <td><form action="/edit" method="post">
            <table>
                <tbody>
                <%--<tr>--%>
                    <%--<td>Edit id:</td>--%>
                    <%--<td>--%>
                        <%--<input type="number" name="newId">--%>
                    <%--</td>--%>
                <%--</tr>--%>
                <tr>
                    <td>Edit Name:</td>
                    <td>
                        <input type="text" name="newName">
                    </td>
                </tr>
                <tr>
                    <td>Edit age:</td>
                    <td>
                        <input type="number" name="newAge">
                    </td>
                </tr>
                <tr>
                    <td>
                        <%--<input type="hidden" name="id" value=<%=user.getId()%>>--%>
                        <input type="hidden" name="name" value=<%=user.getName()%>>
                        <input type="hidden" name="age" value=<%=user.getAge()%>>

                        <input type="submit" value="Edit User">
                    </td>
                </tr>
                </tbody>
            </table>
        </form>
        </td>

        <td>
            <form action="/delete" method="post">
                <table>
                    <tbody>
                    <tr>
                        <td>
                            <input type="hidden" name="id" value=<%=user.getId()%>>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Remove User">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form><%}%>
        </td>
    </tr>
</table>

</body>

</html>
