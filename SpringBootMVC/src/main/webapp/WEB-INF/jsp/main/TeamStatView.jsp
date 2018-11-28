<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <title>TeamSelect</title>

</head>
<body>
<c:choose>
    <c:when test="${not empty teams}">

        <table class="allPlayers">
            <tr>
                <th>TeamName</th>

            </tr>


            <c:forEach var="team" items="${teams}">
                <tr>
                    <td><a href ="/user/stats/${team.id}">${team.name}</a></td>


                </tr>
            </c:forEach>
        </table>
    </c:when>


    <c:otherwise>
        <h3>No teams</h3>
    </c:otherwise>
</c:choose>

</body>
</html>
