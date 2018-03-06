<%-- 
    Document   : cart
    Created on : Feb 4, 2018, 3:34:36 PM
    Author     : zinanwang
--%>

<%@page import="java.util.HashSet"%>
<%@page import="Bean.CatalogBean"%>
<%@page import="Bean.CatalogBean"%>
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
        <%
            HashSet<CatalogBean> cart = (HashSet<CatalogBean>) session.getAttribute("cart");
            if (cart == null) {
                out.println("No items added");
            } else {
                for (CatalogBean c : cart) {
                    out.println("-- " + c.getName() + "<br>");
                }
            }
        %>
        <br>
        [<a href='Catalog?action=books'>Go to Books Page</a>] 
        [<a href="Catalog?action=music">Go to Music Page</a>]
        [<a href="Catalog?action=computers">Go to Computers Page</a>]
    </body>
</html>
