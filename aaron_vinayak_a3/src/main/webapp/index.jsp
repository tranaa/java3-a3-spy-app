<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/index.css' />
        <title>Spy App Home</title>
    </head>
    <body>
        <!-- only appear is a agent is deleted-->
        <c:if test="${deletedAgent != null}" >
            <h1 class="deleted">Missions Deleted for ${deletedAgent}</h1>
        </c:if>
        
        <!-- main interface of app  to view or create mission -->
        <h1>Our Super Cool Spy App</h1>
        <form action="createMission.jsp" method="GET" class="homeForm">
            <h2>Create a Mission:</h2>
            <input type="submit" value="Create a Mission" formaction="createMission.jsp"/>
            </br>
            <h2>View Missions For:</h2>
            Select an agent: <select name="agent">
                <c:forEach var="agent" items="${agents}">
                    <option value="${agent}">${agent}</option>                    
                </c:forEach>
            </select> <input type="submit" value="Go" formaction="viewMissions.jsp" /> 
        </form>
    </body>
</html>
