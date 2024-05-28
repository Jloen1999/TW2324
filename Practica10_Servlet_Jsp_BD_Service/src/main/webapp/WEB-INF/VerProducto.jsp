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
		<div id="Content">
		<% Producto p=(Producto) request.getAttribute("producto");%>
			<h1>Producto</h1>
			<p><table border='1'>
			<tr><td><p><b>Nombre:<%=p.getNombreProd() %></b></p>
			<p><b>Descripción: <%= p.getComentarios() %></b></p><br/>
			<td><img border='0' src="img/<%=p.getPathImagen() %>" width='200' height='150'/></td>			
			</table>
			</div>
	</div>
	<%} %>
</body>
</html>