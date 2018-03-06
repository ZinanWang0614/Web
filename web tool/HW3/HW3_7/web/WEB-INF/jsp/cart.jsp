<%-- 
    Document   : cart
    Created on : Feb 4, 2018, 3:34:36 PM
    Author     : zinanwang
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Shopping Cart</h3>
        <h4>Items:</h4>
        
        <c:if test="${empty cart}">
                No item was selected!<br>
        </c:if>
                
        <c:forEach items="${cart}" var="item">
            -- ${item.name} [$ ${item.price}] <br>
        </c:forEach>
        
        <br>
        [<a href='Catalog.htm?action=books'>Go to Books Page</a>] 
        [<a href="Catalog.htm?action=music">Go to Music Page</a>]
        [<a href="Catalog.htm?action=computers">Go to Computers Page</a>]
    </body>
</html>
