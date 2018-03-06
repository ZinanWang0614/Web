<%-- 
    Document   : movie
    Created on : Feb 23, 2018, 3:31:11 PM
    Author     : zinanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Movie List</h1>
        <c:if test="${empty movieList}">
                No item was selected!<br>
        </c:if>
        <c:forEach items="${movieList}" var="movie">
            ${movie.title}
        </c:forEach>
        
    </body>
</html>
