<%-- 
    Document   : login
    Created on : Aug 15, 2020, 9:24:27 AM
    Author     : duckh
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>LOGIN</h1>
        <s:form action="Login" method="post">
            <s:textfield name="username" id="username" placholder="Username"/>
            <s:password name="password" id="password" placholder="Password"/>
            <s:submit value="Click to Login"/>
        </s:form>
    </body>
</html>
