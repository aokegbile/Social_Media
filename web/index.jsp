
Milka G <mgikunju13@gmail.com>
8:08 PM (0 minutes ago)
to me

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
</head>
<body>
<form action="LoginPage" method="post";>
    <table align="center">
        <tr>
            <td>UserName:</td>
            <td><input type="text" name="uname" required></td>
        <tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" name="pass" min="8" maxlength="20"
                       required></td>
        </tr>

        <tr>
            <td><input type="submit" value="login" /></td>
        </tr>


    </table>
    <span class="error">${messages.uname}</span> <span class="error">${messages.pass}</span>
    <span class="error">${messages.sucess}</span>
</form>
</body>
</html>