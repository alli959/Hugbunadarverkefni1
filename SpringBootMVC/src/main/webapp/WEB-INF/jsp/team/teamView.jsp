
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Team</title>
</head>
<body>

    <h1><a href="/team">Create Team</a></h1>

    <h2>${teamName}</h2>


    <button  type="submit" onclick="location.href='/team?id=${id}/player'">Add Players</button>





</body>
</html>
