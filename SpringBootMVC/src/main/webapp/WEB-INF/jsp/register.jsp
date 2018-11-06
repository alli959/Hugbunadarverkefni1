<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>Registration</title>
</head>
<body>
<sf:form id="regForm" modelAttribute="registerViewPost" action="registerProcess" method="post">
    <table align="center">
        <tr>
            <td>
                <sf:label path="username">Username</sf:label>
            </td>
            <td>
                <sf:input path="username" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td>
                <sf:label path="password">Password</sf:label>
            </td>
            <td>
                <sf:password path="password" name="password" id="password" />
            </td>
        </tr>
        <tr>
            <td>
                <sf:label path="firstname">FirstName</sf:label>
            </td>
            <td>
                <sf:input path="firstname" name="firstname" id="firstname" />
            </td>
        </tr>
        <tr>
            <td>
                <sf:label path="lastname">LastName</sf:label>
            </td>
            <td>
                <sf:input path="lastname" name="lastname" id="lastname" />
            </td>
        </tr>
        <tr>
            <td>
                <sf:label path="email">Email</sf:label>
            </td>
            <td>
                <sf:input path="email" name="email" id="email" />
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
</sf:form>
</body>
</html>