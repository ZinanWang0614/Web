<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form method='post' action='course.htm'>
            <h2> Results found </h2>
            
            <c:forEach items="${searchResults}" var="course">
                
                <input type="checkbox" name="crn" value="${course.crn}"/>${course.crn} - ${course.name}
                [<a href="course.htm?action=add&crn=${course.crn}">Add course </a>]<br/>
                
            </c:forEach>
 
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
