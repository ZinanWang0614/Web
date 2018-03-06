<%-- 
    Document   : addmovie
    Created on : Feb 23, 2018, 7:39:55 PM
    Author     : zinanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter the details below:</h1>
        <form:form>
            Movie Title:<form:input path="title"/>
            Lead Actor: <form:input path="actor"/>
            Lead Actress: <form:input path="actress"/>
            Genre: <form:input path="genre"/>
            Year: <form:input path="year"/>
            <input type="submit" value="Add Movie">
        </form:form>
    </body>
</html>
