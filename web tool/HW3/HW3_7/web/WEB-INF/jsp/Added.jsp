<%-- 
    Document   : cart
    Created on : Feb 4, 2018, 3:18:21 PM
    Author     : zinanwang
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            #catalog{
                width: 80%;
                float:left;
            }
            
            #index{
                
                width: 20%;
                float:left;
                
            }
            
        </style>
    </head>
    <body>
        <div id="index"><jsp:include page="index.jsp"/></div>
        <div id="catalog">
            <h3>The following items has been successfully added into cart:</h3>
        
            <c:if test="${empty store}">
                No item was selected!<br>
            </c:if>
            
        <c:forEach items="${store}" var="item">
            -- ${item.name}<br>
        </c:forEach>
        
        <form>
            <br>
            [<a href='Catalog.htm?action=view'>View Cart</a>] 
            [<a href='Catalog.htm?action=books'>Go to Books Page</a>] 
            [<a href="Catalog.htm?action=music">Go to Music Page</a>]
            [<a href="Catalog.htm?action=computers">Go to Computers Page</a>]
            
        </form>
        </div>
    </body>
</html>
