<!--By default this is true-->
<!--Even if this line is removed, by default the session will continue.-->
<!--Session is an implicit object in JSP-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
         <c:forEach items="${pageContext.request.cookies}" var="usercookie">
        <c:if test="${usercookie.name == 'username1'}">
            <c:redirect url="searchCourse.jsp"></c:redirect>
        </c:if>
        </c:forEach>      
        <div>
            <h1>Login</h1>
            <form name='myForm' method="post" action="login.do?action=login">
                <input type="text" name="username" placeholder="Username" /><br/><br/>
                <input type="password" name="password" placeholder="Password"  /><br/><br/>                
                <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
                <input type="submit" value="Log In" />
            </form>
        </div>
    
</html>
