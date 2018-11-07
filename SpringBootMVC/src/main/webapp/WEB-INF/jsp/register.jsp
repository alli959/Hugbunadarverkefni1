<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Form</title>
</head>
<body>
<form:form name="registerForm" method="POST">
    <div style="color: blue" >${msg}</div>
    <table align="center">
        <tr>
            <td>
                <label path="username">Username</label>
            </td>
            <td>
                <input path="username" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="password">Password</label>
            </td>
            <td>
                <password path="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="firstname">FirstName</label>
            </td>
            <td>
                <input path="firstname" name="firstname" id="firstname" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="lastname">LastName</label>
            </td>
            <td>
                <input path="lastname" name="lastname" id="lastname" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="email">Email</label>
            </td>
            <td>
                <input path="email" name="email" id="email" />
            </td>
        </tr>
        <tr>
            <td>
                <button id="register" name="register">Register</button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="Index.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>