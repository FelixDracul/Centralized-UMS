<%-- 
    Document   : UniversityLogin
    Created on : 05-Apr-2019, 15:17:08
    Author     : Kulitha Abeywardena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>University Login</title>
    </head>
    <body>
        <div>
            <form name="uniLogin" action="LoginDetails" method="POST">
                Enter Username: <input type="text" name="username" value="" />
                <br>
                <br>
                Enter Password: <input type="password" name="pass" value="" />
                <br>
                <br>
                <input type="submit" value="Login"/>
            </form>
        </div>
    </body>
</html>
