<%-- 
    Document   : index
    Created on : Feb 12, 2018, 3:15:24 PM
    Author     : zinanwang
--%>
<%@page import="Bean.Song"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!--******************************************************************-->
        <!--This application uses 5 JSTL core tags: c:forEach c:choose c:out c:set-->
        <!--3 format library tags: fmt:setLocale fmt:formatNumber fmt:parseDate-->
        <!--3 function library tags: fn:length fn:toUpperCase fn:toLowerCase-->
        <!--4 xml library tags: x:parse x:choose x:when x:otherwise-->
        <!--1 sql library tags: sql:setDatasource-->
        <!--******************************************************************-->

        <table border="1">

            <th>Album</th>
            <th>Name Length</th>
            <th>Author</th>
            <th>Song Name</th>
            <th>Price</th>
            <th>Date</th>
                <c:forEach items="${songList}" var="song" varStatus="status">
                    <c:choose>
                        <c:when test="${status.index % 2==0}">
                        <tr style="background: yellow">
                            <td><c:out value="${fn:toUpperCase(song.album)}"></c:out></td>
                            <td>${fn:length(song.name)}</td>
                            <td><c:out value="${fn:toLowerCase(song.author)}"></c:out></td>
                            <td><c:out value="${song.name}"></c:out></td>
                            <td><fmt:setLocale value="en_US"/><fmt:formatNumber value="30" type="currency"/></td>
                            <td><fmt:parseDate value="13-12-2017" var="parsedEmpDate" pattern="dd-MM-yyyy"/>
                                <c:out value="${parsedEmpDate}"></c:out></td>
                            </tr>
                    </c:when>                    
                    <c:when test="${status.index % 2==1}">
                        <tr style="background: bisque">
                            <td><c:out value="${song.album}"></c:out></td>
                            <td>${fn:length(song.name)}</td>
                            <td><c:out value="${song.author}"></c:out></td>
                            <td><c:out value="${song.name}"></c:out></td>
                            <td><fmt:setLocale value="en_US"/><fmt:formatNumber value="20" type="currency"/></td>
                            <td><fmt:parseDate value="13-12-2017" var="parsedEmpDate" pattern="dd-MM-yyyy"/>
                                <c:out value="${parsedEmpDate}"></c:out></td>
                            </tr>
                    </c:when>                  
                </c:choose>
            </c:forEach>
        </table>

        <br><br>

        <!--xml part-->

        <c:set var="xmltext">
        <books>
            <book>
                <name>Twenty years later</name>
                <author>Alexandre Dumas Pėre</author>
                <price>100</price>
            </book>
            <book>
                <name>The Great Alone</name>
                <author>Kristin Hannah</author>
                <price>2000</price>
            </book>
        </books>
    </c:set>

    <x:parse xml="${xmltext}" var="output"/>
    <x:choose>
        <x:when select="$output//book/author = 'Alexandre Dumas Pėre'">
            Book is written by Alexandre Dumas Pėre
        </x:when>
        <x:when select="$output//book/author = 'Kristin Hannah'">
            Book is written by Kristin Hannah
        </x:when>
        <x:otherwise>
            Unknown author.
        </x:otherwise>
    </x:choose>



    <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://newton.neu.edu:3306/usersdb"
                       user="student"  password="p@ssw0rd"/>
    
    <!--data-->
    <%
        ArrayList<Song> songList = new ArrayList<Song>();

        Song s1 = new Song();
        s1.setAlbum("reputation");
        s1.setAuthor("Taylor Swift");
        s1.setName("Ready for it");

        Song s2 = new Song();
        s2.setAlbum("reputation");
        s2.setAuthor("Taylor Swift");
        s2.setName("End Game(feat. Ed Sheeran & Future)");

        Song s3 = new Song();
        s3.setAlbum("reputation");
        s3.setAuthor("Taylor Swift");
        s3.setName("I Did Something Bad");

        Song s4 = new Song();
        s4.setAlbum("reputation");
        s4.setAuthor("Taylor Swift");
        s4.setName("Don't Blame Me");

        Song s5 = new Song();
        s5.setAlbum("reputation");
        s5.setAuthor("Taylor Swift");
        s5.setName("Delicate");

        Song s6 = new Song();
        s6.setAlbum("reputation");
        s6.setAuthor("Taylor Swift");
        s6.setName("Look What You Made Me Do");

        Song s7 = new Song();
        s7.setAlbum("reputation");
        s7.setAuthor("Taylor Swift");
        s7.setName("So It Gose...");

        Song s8 = new Song();
        s8.setAlbum("reputation");
        s8.setAuthor("Taylor Swift");
        s8.setName("Gorgeous");

        Song s9 = new Song();
        s9.setAlbum("reputation");
        s9.setAuthor("Taylor Swift");
        s9.setName("Getway Car");

        Song s10 = new Song();
        s10.setAlbum("reputation");
        s10.setAuthor("Taylor Swift");
        s10.setName("King of My Heart");

        Song s11 = new Song();
        s11.setAlbum("reputation");
        s11.setAuthor("Taylor Swift");
        s11.setName("Dancing With Our Hands Tied");

        Song s12 = new Song();
        s12.setAlbum("reputation");
        s12.setAuthor("Taylor Swift");
        s12.setName("Dress");

        Song s13 = new Song();
        s13.setAlbum("reputation");
        s13.setAuthor("Taylor Swift");
        s13.setName("This Is Why We Can't Have Nice Things");

        Song s14 = new Song();
        s14.setAlbum("reputation");
        s14.setAuthor("Taylor Swift");
        s14.setName("Call It What You Want");

        Song s15 = new Song();
        s15.setAlbum("reputation");
        s15.setAuthor("Taylor Swift");
        s15.setName("New Year's Day");

        songList.add(s1);
        songList.add(s2);
        songList.add(s3);
        songList.add(s4);
        songList.add(s5);
        songList.add(s6);
        songList.add(s7);
        songList.add(s8);
        songList.add(s9);
        songList.add(s10);
        songList.add(s11);
        songList.add(s12);
        songList.add(s13);
        songList.add(s14);
        songList.add(s15);

        session.setAttribute("songList", songList);
    %>





</body>
</html>
