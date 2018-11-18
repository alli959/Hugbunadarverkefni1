<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Login Form</title>
</head>
<body>
<sf:form method="POST" modelAttribute="users" action="/login">

    <div align="center">
        <div style="color: black">${infoMessage}</div>
        <div style="color: blue" >${msg}</div>
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" /></td>
            </tr>
            <tr>

            </tr>
        </table>
        <div style="color: red">${error}</div>


    </div>
    <input type="submit" value="Submit" />
</sf:form>
</body>
</html>