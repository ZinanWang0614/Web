<%-- 
    Document   : index
    Created on : Feb 23, 2018, 6:56:56 PM
    Author     : zinanwang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to our Movie Store</h1>
        <br/>
        <p>Please make your selection below</p>
        <form action="movie.htm" method="post">
            <select name="action" >
                <option value="browse"><p>Browse Movie</p></option>
                <option value="add"><p>Add New Movie to Database</p></option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Send">
        </form>
    </body>
</html>
