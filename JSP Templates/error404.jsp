<%@page import="es.unex.cum.tw"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.*"%>

<!DOCTYPE html>
<html data-bs-theme="auto">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>
    <link rel="icon" href="../img/favicon.png" />
    <link href="CSS/css.css" rel="stylesheet">
</head>

<body>
<header>
    <jsp:include page="nav_autenticado.jsp" />
</header>
<main>
    <div class="container">
            <%
                if (request.getParameter("error") != null) {
                    out.println(request.getParameter("error"));
                }
            %>
    </div>
</main>
<footer class="foot">
    <p>&copy; 2024 TW 23 - 24 - Todos los derechos reservados</p>
</footer>
</body>

</html>