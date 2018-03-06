<%-- 
    Document   : Catalog
    Created on : Feb 4, 2018, 2:35:16 PM
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
                width: 70%;
                float:left;
                border-left:solid;
                
            }
            
            #index{
                
                width: 10%;
                float:left;
                
            }
            
            #view{
                width: 60%;               
                text-align: right;                
            }
            
            #shop{
                
                border-bottom: solid;
                padding-left: 5%;
            }
            
            #list{
                
                padding-left: 5%
            }
            
            
        </style>
    </head>
    <body>
        <div id="index"><jsp:include page="index.jsp"/></div>  
        <div id="catalog">
            <div id="shop">               
                <h3>Shop for ${type}</h3>
            </div>
            <div id="view">
                [<a href='Catalog.htm?action=view'>View Cart</a>] 
            </div>
            <div id="list">
                <form action="Catalog.htm" method="post">
            <c:forEach items="${List}" var="item">
                <input type="checkbox" name="content" value="${item.name}"> ${item.name} [$ ${item.price}]
                <br>
                <br>
            </c:forEach>
            <input type="hidden" value="add" name="action">
            <br>
            <br>
            <input type="submit" value="Add selected items">
            </form>
            </div>
        </div>
        
    </body>
</html>
