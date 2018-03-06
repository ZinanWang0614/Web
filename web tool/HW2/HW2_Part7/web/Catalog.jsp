<%-- 
    Document   : Catalog
    Created on : Feb 4, 2018, 2:35:16 PM
    Author     : zinanwang
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Bean.CatalogBean"%>
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
                <% String action = request.getParameter("action");%>
                <h3>Shop for <%= action%></h3>
            </div>
            <div id="view">
                [<a href='Catalog?action=view'>View Cart</a>] 
            </div>
            <div id="list">
                <form action="Catalog" method="post">
            <% 
                ArrayList<CatalogBean> booksList=(ArrayList<CatalogBean>) request.getAttribute("List");
                for(CatalogBean c:booksList){
                    out.println("<input type='checkbox' name='content' value='"+c.getName()+"'>"+c.getName());
                    out.println("   [$"+c.getPrice()+"]");
                    out.println("<br>");
                    out.println("<br>");
                }
            %>
            <input type="hidden" value="add" name="action">
            <br>
            <br>
            <input type="submit" value="Add selected items">
            </form>
            </div>
        </div>
        
    </body>
</html>
