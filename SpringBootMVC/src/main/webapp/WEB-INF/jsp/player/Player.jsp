
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">


    <%--private String name;
    private Long playerNo;
    private String playerPos;--%>
    <head>
        <title>Create Players</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/player.css"/>"/>
    </head>
    <body>

    <h1><a href="/player">Players</a></h1>

    <sf:form method="POST" modelAttribute="playerView" action="/player">

        <table>
            <tr>

                    <td>Player nr. ${playerNo + 1}</td>
                    <td>Name:</td>
                    <td><sf:input path="name" type="text" placeholder="Enter player name"/></td>
            </tr>
            <tr>
                <td>Position:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="playerPos" type="text" placeholder="C,P,S,SG or PG"/></td>
            </tr>

        </table>

        <input type="submit" VALUE="Add to team"/>

    </sf:form>

    <%--Choose what code to generate based on tests that we implement--%>
    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty players}">
            <%--Create a table for the Postit Notes--%>
            <table class="allPlayers">

                    <%--For each postit note, that is in the list that was passed in the model--%>
                    <%--generate a row in the table--%>
                    <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="player" items="${players}">
                    <tr>
                            <%--We can reference attributes of the Entity by just entering the name we gave--%>
                            <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                            <%--Create a link based on the name attribute value--%>
                        <td><a href="/player/${player.name}">${player.name}</a></td>
                            <%--The String in the note attribute--%>
                        <td>${player.playerPos}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No players!</h3>
        </c:otherwise>
    </c:choose>
    </body>

</html>
