<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' type='text/css' href='css/index.css' />
        <title>Create Mission Page</title>
    </head>
    <body>
        <h1>Create a Mission</h1>

        <form action="CreateMission.do" method="POST">
            Mission Title: <input type="text" name="missionTitle" required><br><br>
            
            Select the Agent:
            <!-- Select element for agents -->
            <select name="agent">
                <c:forEach var="agent" items="${agents}">
                    <option value="${agent}">${agent}</option>                    
                </c:forEach>
            </select>

            <h2>Select the Gadgets</h2>
            
            <!-- checkbox and input element for gadgets -->
            <div class="gadgetList">
                <c:forEach var="gadget" items="${gadgets}">
                    <input type="checkbox" name="gadgets" value="${gadget.name}" />${gadget.name.trim()}
                    <br>
                </c:forEach>
                <br>
                Other Gadget <input type="text" name="gadgets">
            </div><br>
            
            <input type="Submit" value="Create Mission" />
        
            <a href="index.jsp">Back to Home Page</a>
        </form>
    </body>
</html>
