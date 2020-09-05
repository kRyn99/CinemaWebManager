<%-- 
    Document   : homePage
    Created on : Aug 15, 2020, 3:22:49 PM
    Author     : duckh
--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>This is HOME PAGE!</h1><hr/>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Citizen ID</th>
        <th>Birth date</th>
    </tr>
    <s:iterator value="customers">
        <tr>
           <td><s:property value="id"/></td>
           <td><s:property value="name"/></td>
           <td><s:property value="citizenID"/></td>
           <td><s:property value="birthDate"/></td>
        </tr>
    </s:iterator>
</table>
