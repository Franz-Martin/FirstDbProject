<%-- 
    Document   : create
    Created on : 15.01.2025, 09:10:07
    Author     : trainer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="adressCtrl" class="com.ibb.ctrl.AdressController" scope="session" />
<%
  adressCtrl.createAdress();
 response.sendRedirect("index.jsp");


%>
