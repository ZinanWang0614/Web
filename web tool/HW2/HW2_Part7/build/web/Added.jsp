<%-- 
    Document   : cart
    Created on : Feb 4, 2018, 3:18:21 PM
    Author     : zinanwang
--%>

<%@page import="Bean.CatalogBean"%>
<%@page import="java.util.HashSet"%>
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
        
        <%
            HashSet<CatalogBean> store = (HashSet<CatalogBean>) request.getAttribute("store");
            if (store == null) {
                    out.println("No items added");
                }
            else{
                for(CatalogBean c:store){
                    out.println("-- "+c.getName()+"<br>");
                }
            }
        %>
        <form>
            <br>
            [<a href='Catalog?action=view'>View Cart</a>] 
            [<a href='Catalog?action=books'>Go to Books Page</a>] 
            [<a href="Catalog?action=music">Go to Music Page</a>]
            [<a href="Catalog?action=computers">Go to Computers Page</a>]
            
        </form>
        </div>
    </body>
</html>
