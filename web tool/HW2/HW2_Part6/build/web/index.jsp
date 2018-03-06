<%-- 
    Document   : index
    Created on : Feb 4, 2018, 1:25:39 AM
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
        
        <%  String number =(String) session.getAttribute("number");%>
        
        <script>
            
            var number = parseInt(<%= number%>); 
            
            for(var i=0;i<number;i++){
                document.write("<p> Please input the name of chidern number "+(i+1)+"</p>");
                document.write("<form action='HW2_Part6' method='post'>");
                document.write("<input type='text' name = '"+i+"'>");
            }
            document.write("<br>");
            document.write("<br>");
            document.write("<input type='submit' value='submit'>");
            document.write("</form>");    
        </script>
       
    </body>
</html>
