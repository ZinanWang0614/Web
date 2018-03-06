<%-- 
    Document   : index
    Created on : Feb 2, 2018, 2:59:04 PM
    Author     : zinanwang
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Enumeration enu = request.getHeaderNames();
            while (enu.hasMoreElements()) {
                String headerName = (String) enu.nextElement();
                String headerValue = request.getHeader(headerName);
        %>
        <h5><%=headerName%><font color="red">--></font>
            <font color="blue"><%=headerValue%></font></h5>
            <%
                }
            %>
    </bod
</html>
