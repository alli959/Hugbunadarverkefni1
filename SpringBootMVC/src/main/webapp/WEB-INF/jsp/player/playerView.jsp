
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

<header class="header">
    <div class="header__contents">
        <input type="button" onclick="location.href = '/user'" value="<== Back To Main Menu"/>
        <div class="header__menu">
            <div class="header__menu__user">
                <a class="header__menu__item">${msg}</a>
                <input type="button" onclick="location.href = '/logout'" value="Logout" />
            </div>
        </div>
    </div>
</header>

    <ul class = "navBar">
        <li><h2><a href="/user/team">Create Team</a></h2></li>
        <li><h2><a href="/user/team/${teamId}">Team</a></h2></li>
        <li><h2><a href="/user/team/${teamId}/player">Add Players</a></h2></li>
        <li><h2><a href="/user/team/${teamId}/player/${name}">Players</a></h2></li>
    </ul>

    <h1> ${name} </h1>

    <h1>TODO</h1>







</body>
</html>
