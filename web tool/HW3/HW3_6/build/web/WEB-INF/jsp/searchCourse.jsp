<%-- 
    Document   : searchCourse
    Created on : Feb 12, 2018, 7:09:03 PM
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
        <div>
            <h2> Search Courses</h2>
            <form id="form" action="course.htm" method="get" >
                <a href="login.htm?action=logout">Logout</a>&nbsp;&nbsp;
                <a href="course.htm?action=mycourse">My Courses</a>
                <br />
                <br />                 
                Search Query <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" value="crn" checked=""/> Search By CRN
                <input type="radio" name="searchType" value="title"/> Search By Instructor or Title
                <input type="hidden" name="action" value="search" />
                <br/><input type="submit" value="SEARCH"/>
            </form>
        </div>
    </body>
</html>
