<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
    <title>Main page</title>

</head>

<body>

    <header class="header">
        <div class="header__contents">
            <h1 class="header__title">BBall StatTracker</h1>
            <div class="header__menu">
                <ul class="header__menu__list">
                    <li>
                        <a class="header__menu__item" href="<c:url value="/user/team"/>">Create Team</a>
                    </li>
                    <li>
                        <a class="header__menu__item" href="">Stats</a>
                    </li>
                </ul>
                <div class="header__menu__user">
                    <a class="header__menu__item">${msg}</a>
                    <input type="button" onclick="location.href = '/logout'" value="Logout" />
            </div>
        </div>
        </div>
    </header>

    <div class="main">
        <a href="/user/pregame"><button>Start</button></a>
    </div>
    <div style="display: flex;justify-content: center" class="image">
        <img style="zoom: 1.1" src="<c:url value="/image/bballcourt.png"/>" usemap="#image-map">
    </div>

    <map name="image-map">
        <area target="" alt="LeftWingThree" title="LeftWingThree" href="" coords="479,554,481,367,293,367,250,436,165,481,164,557,287,554,386,555" shape="poly">
        <area target="" alt="RightWingThree" title="RightWingThree" href="" coords="481,25,168,23,168,96,240,132,294,202,480,204" shape="poly">
        <area target="" alt="TopThree" title="TopThree" href="" coords="482,204,294,203,312,282,294,366,479,366" shape="poly">
        <area target="" alt="LeftCornerThree" title="LeftCornerThree" href="" coords="44,555,43,491,126,491,164,482,163,556" shape="poly">
        <area target="" alt="RightCornerThree" title="RightCornerThree" href="" coords="43,24,43,86,132,87,167,95,167,22,122,23" shape="poly">
        <area target="" alt="LeftShortCorner" title="LeftShortCorner" href="" coords="45,360,45,490,123,490,125,360" shape="poly">
        <area target="" alt="RightShortCorner" title="RightShortCorner" href="" coords="43,87,45,218,125,217,127,87" shape="poly">
        <area target="" alt="LeftTopKey" title="LeftTopKey" href="" coords="126,358,124,492,165,482,225,450,252,434,298,359" shape="poly">
        <area target="" alt="RightTopKey" title="RightTopKey" href="" coords="124,217,128,87,168,95,240,133,292,199,297,220" shape="poly">
        <area target="" alt="TopKey" title="TopKey" href="" coords="178,218,179,359,296,358,312,284,299,218" shape="poly">
        <area target="" alt="LayUp" title="LayUp" href="" coords="46,218,178,359" shape="rect">
    </map>

</body>

</html>

