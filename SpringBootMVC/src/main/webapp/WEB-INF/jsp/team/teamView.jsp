
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>TeamView</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/teamView.css"/>"/>
</head>
<body>

    <ul class = "navBar">

        <li><h2><a href="/user/team">Create Team</a></h2></li>
        <li><h2><a href="/user/team/${teamId}">Team</a></h2></li>

    </ul>


    <h2>${teamName}</h2>


    <button  type="submit" onclick="location.href='/user/team/${teamId}/player'">Add Players</button>





</body>
</html>
