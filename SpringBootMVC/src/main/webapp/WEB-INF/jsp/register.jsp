<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Form</title>
</head>
<body>
<sf:form name="registerForm" modelAttribute="createUser" method="POST" action="/register">
    <div style="color: blue" >${msg}</div>
    <table align="center">
        <tr>
            <td>
                <label path="name">Name:</label>
            </td>
            <td>
                <sf:input type="text" path="name" name="name" id="name" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="userName">User Name:</label>
            </td>
            <td>
                <sf:input path="userName" name="userName" id="userName" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="password">Password:</label>
            </td>
            <td>
                <sf:input type="password" path="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td>
                <label path="email">Email</label>
            </td>
            <td>
                <sf:input type="email" path="email" name="email" id="email" />
            </td>
        </tr>
        <tr>
            <td>
                <sf:button id="register" name="register">Register</sf:button>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td></td>
            <td><a href="Index.jsp">Home</a>
            </td>
        </tr>
    </table>
    <div style="color: red">${error}</div>
</sf:form>
</body>
</html>