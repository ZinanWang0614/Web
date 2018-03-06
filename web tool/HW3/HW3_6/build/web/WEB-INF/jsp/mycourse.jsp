<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
        
        <c:if test="${fn:length(myCourseSet)==0}">
            <div><p>No Course Added for you.</p></div>
        </c:if>
        
        <c:forEach items="${myCourseSet}" var="myCourse">
            <p>CRN: ${myCourse.crn} - Course Name: ${myCourse.name} [<a href="course.htm?action=remove&crn=${myCourse.crn}">Remove Course</a>]</p>
        </c:forEach>

    </body>
</html>
