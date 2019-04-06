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
            <h1>Welcome,<%= session.getAttribute("username") %></h1>
            <br><br>
            <form name="logout" action="Logout" method="POST">
                <input type="submit" value="Logout" name="logout" />
            </form>
            <br><br><br>
            <!--<form action="AddQuery" method="POST">
                <input type="text" name="query" value="" />
                <input type="submit" value="Submit" name="submit" />
            </form>-->
            
            <form action="FileUpload" method="POST" enctype="multipart/form-data">
                Select Project File: &nbsp;
                <input type="file" name="file" value="" /> <br><br>
                <input type="submit" value="Upload" name="upload" />                
            </form>
        </div>
    </body>
</html>
