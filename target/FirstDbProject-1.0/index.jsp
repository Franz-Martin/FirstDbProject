<%-- 
    Document   : index
    Created on : 30.12.2014, 11:01:22
    Author     : Schulung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="adressCtrl" class="com.ibb.ctrl.AdressController" scope="session" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        out.print("<p>Anzahl Adressen:"+adressCtrl.getAllAdresses().size()+"</p>");
        
        %>
        <a href="adress.jsp">Adressen</a>
        <form action="create.jsp">
            <input type="submit" value="create Adresses" />
        </form>
    </body>
</html>
