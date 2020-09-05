<%-- 
    Document   : header
    Created on : Aug 15, 2020, 3:09:07 PM
    Author     : duckh
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>This is Menu</h1>
<s:url action="Prepare.action" var="prepareURL" />
<s:a href="%{prepareURL}">Home page</s:a>
<hr/>