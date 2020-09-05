<%-- 
    Document   : index
    Created on : Aug 15, 2020, 9:21:43 AM
    Author     : duckh
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:getAsString name="title" ignore="true"/></title>
        <tiles:insertTemplate template="/WEB-INF/jsp/pages/layout/include.jsp"/>
    </head>
    <body>
        <div id="header">
            <tiles:insertAttribute name="header"/>
        </div>
        <div id="menu">
            <tiles:insertAttribute name="menu"/>
        </div>
        <div id="body">
            <tiles:insertAttribute name="body"/>
        </div>
        <div id="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
