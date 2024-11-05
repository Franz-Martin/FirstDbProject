<%-- 
    Document   : adress
    Created on : 05.11.2024, 10:22:30
    Author     : trainer
--%>

<%@page import="com.ibb.model.Adress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="adressCtrl" class="com.ibb.ctrl.AdressController" scope="page" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Ort</th>
                    <th>Vorname</th>
                    <th>Nachname</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
            <h1><%=adressCtrl.getAllAdresses().size()%></h1>
                <% for (Adress a : adressCtrl.getAllAdresses()) {
                        out.print("<tr><td>" + a.getOrt() + "</td><td>" + a.getVorname() + "</td><td>"
                                + a.getNachname() + "</td><td>" + a.getEmail() + "</td></tr>");
                    }
                %>
            </tbody>
        </table>

    </body>
</html>
