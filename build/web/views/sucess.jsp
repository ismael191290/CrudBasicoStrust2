<%-- 
    Document   : sucess
    Created on : Oct 10, 2018, 10:59:45 AM
    Author     : Isma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Success!</h1>
         <s:property value="person.getName()"></s:property>
          <s:property value="person.getLname()"></s:property>
          
          <form action="consulta" method="POST">
              <button type="submit">Consultar!!</button>
          </form>
          
    </body>
</html>
