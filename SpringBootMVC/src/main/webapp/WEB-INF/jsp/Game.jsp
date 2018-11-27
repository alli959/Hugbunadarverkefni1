<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="<c:url value="/css/timer.js"/>"></script>
    <script src="<c:url value="/css/game.js"/>"></script>
    <meta charset="UTF-8">
    <title>The Game</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/css/game.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/radioButtons.css"/>"/>
</head>
<body>

<div class="container">
    <div class="score home">0</div>
    <div class="timer"></div>
    <div class="score away">0</div>
</div>
<div class="container__buttons">
    <div class="container__home">Home</div>
    <button class="button setup" onclick="setup()">Set time</button>
    <button class="button stop" onclick="startStop()">Start/Stop</button>
    <div class="container__away">Away</div>
</div>

<div class="game">
    <div class="game__shot hidden">
        <button type="button" value="1" onclick="shot(value)" class="button">Made shot</button>
        <button type="button" value="0" onclick="shot(value)" class="button">Missed shot</button>

    </div>

    <div class="game__assist hidden">
        <div>
        <h3>Assist by:</h3>
        </div>
        <c:choose>
            <c:when test="${not empty starters}">
                <c:forEach var="starter" items="${starters}">
                        <button value="${starter.id}" class="button" type="button" onclick="assist(value)">${starter.name}</button>
                </c:forEach>
                <button value="0" class="button" type="button">None</button>
            </c:when>
        </c:choose>
    </div>

    <div class="game__rebound hidden">
        <div>
            <h3>Rebound for:</h3>
        </div>
        <c:choose>
            <c:when test="${not empty starters}">
                <c:forEach var="starter" items="${starters}">
                    <button value="${starter.id}" class="button" type="button" onclick="rebound(value)">${starter.name}</button>
                </c:forEach>
                <button value="0" class="button" type="button">None</button>
            </c:when>
        </c:choose>
    </div>


    <div class="game__button">
        <div class="funkyradio">
        <c:choose>
    <c:when test="${not empty starters}">

            <c:forEach var="starter" items="${starters}">
            <div class="funkyradio-info">
                <input type="radio" name="radio" id="${starter.id}" value="${starter.id}" onclick="selectedPlayer(value)">
                <label for="${starter.id}">${starter.name}<br>${starter.playerPos}<br>${starter.playerNr}</label>
            </div>
            </c:forEach>
    </c:when>
</c:choose>
        </div>

        <c:choose>
            <c:when test="${not empty players}">

                <c:forEach var="player" items="${players}">

                    <button class="button bench" type="button">${player.name}</button>

                </c:forEach>
            </c:when>

        </c:choose>

    </div>
<div>
    <img src="<c:url value="/image/bballcourt.png"/>" usemap="#image-map">
</div>

</div>

<div class="other">
    <button class="button">Foul</button>
    <button class="button">Steal</button>
    <button class="button">Turnover</button>
</div>

<!--onclick="location.href = 'leftwingthree'"-->
<map name="image-map">
    <area target="" alt="LeftWingThree" title="LeftWingThree" onclick="shotPos(title)" coords="479,554,481,367,293,367,250,436,165,481,164,557,287,554,386,555" shape="poly">
    <area target="" alt="RightWingThree" title="RightWingThree" onclick="shotPos(title)" coords="481,25,168,23,168,96,240,132,294,202,480,204" shape="poly">
    <area target="" alt="TopThree" title="TopThree" onclick="shotPos(title)" coords="482,204,294,203,312,282,294,366,479,366" shape="poly">
    <area target="" alt="LeftCornerThree" title="LeftCornerThree" onclick="shotPos(title)" coords="44,555,43,491,126,491,164,482,163,556" shape="poly">
    <area target="" alt="RightCornerThree" title="RightCornerThree" onclick="shotPos(title)" coords="43,24,43,86,132,87,167,95,167,22,122,23" shape="poly">
    <area target="" alt="LeftShortCorner" title="LeftShortCorner" onclick="shotPos(title)" coords="45,360,45,490,123,490,125,360" shape="poly">
    <area target="" alt="RightShortCorner" title="RightShortCorner" onclick="shotPos(title)" coords="43,87,45,218,125,217,127,87" shape="poly">
    <area target="" alt="LeftTopKey" title="LeftTopKey" onclick="shotPos(title)" coords="126,358,124,492,165,482,225,450,252,434,298,359" shape="poly">
    <area target="" alt="RightTopKey" title="RightTopKey" onclick="shotPos(title)" coords="124,217,128,87,168,95,240,133,292,199,297,220" shape="poly">
    <area target="" alt="TopKey" title="TopKey" onclick="shotPos(title)" coords="178,218,179,359,296,358,312,284,299,218" shape="poly">
    <area target="" alt="LayUp" title="LayUp" onclick="shotPos(title)" coords="46,218,178,359" shape="rect">
</map>

<c:if test="${clicked}">
<p>hello</p>
</c:if>

</body>
</html>