<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Project Title</title>
    </head>
    <body>


    <ul>
        <li><a href="/register">Click here to register</a></li>
        <p>Already have an account?</p>
        <li><a href="/login">Login</a></li>
        <li><a href="<c:url value="/game"/>">Game</a></li>
    </ul>
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
