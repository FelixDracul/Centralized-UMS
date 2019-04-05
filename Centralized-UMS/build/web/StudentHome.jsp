<%-- 
    Document   : StudentHome
    Created on : 05-Apr-2019, 15:26:48
    Author     : Kulitha Abeywardena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        
        <%
            if(session.getAttribute("username")==null){
                response.sendRedirect("StudentLogin.jsp");
            }
        %>
        
        <div>
            <h1>Welcome, $(username)!</h1>
            <br>
            <br>
            <form name="logout" action="Logout" method="POST">
                <input type="submit" value="Logout" name="logout" />
            </form>
        </div>
    </body>
</html>
