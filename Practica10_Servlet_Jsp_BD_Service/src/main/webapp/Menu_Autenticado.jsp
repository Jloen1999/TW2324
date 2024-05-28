<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="Menu">
	<form id="form1" action="${pageContext.request.contextPath}/Restringido/Action" method="post">
		<a href="javascript:;"
			onclick="document.getElementById('form1').submit();">Ver Productos</a> 
			<input type="hidden" name="action" value="VerProductos" />
	</form>
	<form id="form2" action="${pageContext.request.contextPath}/Restringido/Action" method="post">
		<a href="javascript:;"
			onclick="document.getElementById('form2').submit();">Ver Carta</a> 
			<input type="hidden" name="action" value="VerCarta" />
	</form>
	<a href='${pageContext.request.contextPath}/Restringido/Action?action=InfoUsuario' title='Info Usuario'>Info usuario</a><br /> 
	<a href='${pageContext.request.contextPath}/Logout.jsp' title=''>Logout</a><br /> 
	Usuario:<%=session.getAttribute("nombre")%>
</div>