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
                    <button class="header__menu__item">Sign out</button>
                </div>
            </div>
        </div>
    </header>

    <div class="main">
        <button><a href="/game">Start</a></button>
    </div>
    <div style="display: flex;justify-content: center" class="image">
        <img style="zoom: 1.2" src="<c:url value="/image/bballcourt.png"/>" usemap="#image-map">
    </div>

    <map name="image-map">
        <area target="" alt="LeftWingThree" title="LeftWingThree" href="" coords="480,550,481,359,299,357,250,436,174,482,173,555,287,554" shape="poly">
        <area target="" alt="RightWingThree" title="RightWingThree" href="" coords="481,25,168,23,168,96,239,132,289,195,480,196" shape="poly">
        <area target="" alt="TopThree" title="TopThree" href="" coords="480,196,287,195,312,282,299,357,482,359" shape="poly">
        <area target="" alt="LeftCornerThree" title="LeftCornerThree" href="" coords="44,555,43,491,126,491,174,481,172,556" shape="poly">
        <area target="" alt="RightCornerThree" title="RightCornerThree" href="" coords="43,24,43,86,132,87,167,95,167,22" shape="poly">
    </map>

</body>

</html>

