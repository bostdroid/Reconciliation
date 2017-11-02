<%-- 
    Document   : globalresult
    Created on : 15-Feb-2017, 14:31:20
    Author     : TechDEv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib  prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asset TrackEdge</title>
    </head>
    <body>
            Sorry an exception occured!  
            <p>Exception Name: <s:property value="exception" /> </p>  
            <p>Exception Details: <s:property value="exceptionStack" /></p>  
            <form>  
            <input type="button" value="back" onclick="history.back()">  
            </form> 
    </body>
</html>

  
 