<%-- 
    Document   : listPerona
    Created on : Oct 10, 2018, 9:26:38 PM
    Author     : Isma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Lista de Personas !!</h1>

        <table>
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Lname</td>
                    <td>Editar</td>
                    <td>Eliminar</td>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="listPerson">
                    <tr>
                        <td><s:property value="idPersona"></s:property></td>
                        <td><s:property value="name"></s:property></td>
                        <td><s:property value="lname"></s:property></td>
                            <td>
                            <s:url id="editURL" action="editUser">
                                <s:param name="idPersona" value="%{idPersona}"></s:param>
                            </s:url>
                            <s:a href="%{editURL}">Edit</s:a>
                            </td>
                            <td>
                            <s:url id="deleteURL" action="deleteUser">
                                <s:param name="idPersona" value="%{idPersona}"></s:param>
                            </s:url>
                            <s:a href="%{deleteURL}">Delete</s:a>
                            </td>


                        </tr>
                </s:iterator>
            </tbody>
        </table>

    </body>
</html>
