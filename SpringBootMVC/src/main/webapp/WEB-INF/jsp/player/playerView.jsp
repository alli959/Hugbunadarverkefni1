
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Player</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/playerView.css"/>"/>
</head>
<body>

    <ul class = "navBar">
        <li><h2><a href="/user/team">Create Team</a></h2></li>
        <li><h2><a href="/user/team/${teamId}">Team</a></h2></li>
        <li><h2><a href="/user/team/${teamId}/player">Add Players</a></h2></li>
        <li><h2><a href="/user/team/${teamId}/player/${name}">Players</a></h2></li>
    </ul>

    <h1> ${name} </h1>




</body>
</html>
