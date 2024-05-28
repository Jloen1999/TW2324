<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" import="java.util.*,es.unex.cum.tw.reyesmagos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf8" />
<title>Carta a los reyes Magos</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CSS.css" />
</head>
<body>
<%
   if (session.getAttribute("nombre")==null)   {
       response.sendRedirect("../Login.jsp");
   } else {
%>
    <%@ include file="../Cabecera.jsp"%>
    <div id="contenedor">
        <jsp:include page ="../Menu_Autenticado.jsp"/>
        <%
            if (request.getParameter("error") != null) {
                out.println(request.getParameter("error"));
            }
        %>
        <div id="Content">
        <%
            Usuario user=(Usuario) request.getAttribute("usuario");%>         
            <h1>Información de usuario</h1>
            <p>
            <table border='1'>
                <tr>
                    <td><b>Nombre</b></td>
                    <td><b>Apellido</b></td>
                    <td><b>Email</b></td>
                </tr>
                <tr>
                    <td>Nombre: <%= user.getNombre() %></td>
                    <td>Apellidos: <%= user.getApellidos() %></td>
                    <td>Email: <%= user.getEmail() %></td>
                    <td><a href="Action?action=eliminarUsuario&idUsuario=<%= user.getId()%>">Eliminar Cuenta</a></td>
                </tr>
            </table>
            </p>
        </div>
    </div>
<% } %>
</body>
</html>
