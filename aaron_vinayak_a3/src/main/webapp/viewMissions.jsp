<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/index.css' />
        <title>View Missions Page</title>
    </head>
    <body>
        <c:set var="missionCounter" value="1" scope="request" />
        
        <h1>Here Are The Missions For ${param.agent.trim()}</h1>
        <!-- displays selected agents missions -->
        <c:if test="${sessionScope[param.agent].missions == null}">
            <h2>There Are No Missions</h2>
        </c:if>
        
        <div class="missionContainer">
            <c:forEach var="mission" items="${sessionScope[param.agent].missions}">
                <div class="mission">
                    <h2>Mission ${missionCounter}: ${mission.name}</h2>
                    <div id="gadgetList">
                        <hr>Gadgets:
                        <c:choose>
                            <c:when test="${mission.gadgets.size() > 0}">
                                <ul>
                                    <c:forEach var="gadget" items="${mission.gadgets}">
                                        <li>${gadget.name}</li>                    
                                        </c:forEach>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                No Gadgets Used
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <c:set var="missionCounter" value="${missionCounter + 1}" />
            </c:forEach>
        </div>
        <form action="DeleteMission.do" method="POST">
            <c:if test="${sessionScope[param.agent].missions.size() > 0}">
                <input type="hidden" name="agent" value="${param.agent.trim()}" />
                <input type="submit" value="Delete missions for ${param.agent.trim()}" />
            </c:if>
            <br><a href="index.jsp">Back to Home Page</a>
        </form> 
        
    </body>
</html>