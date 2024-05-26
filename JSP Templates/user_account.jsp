<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    if (session.getAttribute("name") == null) {
        response.sendRedirect("../Login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/css.css"/>
    <!-- Icono favicon -->
    <link rel="icon" href="img/favicon.png"/>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="nav_autenticado.jsp"/>
</header>
<div class="container">
    <h1>Account Information</h1>

    <h2>
        Welcome,
        <%=session.getAttribute("name")%>!
    </h2>

    <hr>

    <h3>Edit Profile:</h3>
    <form action="Action" method="post">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%=session.getAttribute("name")%>" required>


        <label for="lastname">Last Name:</label>
        <input type="text" id="lastname" name="lastname" value="<%=session.getAttribute("lastname")%>" required>


        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=session.getAttribute("email")%>" required>

        <input type="hidden" name="action" value="userupdate">
        <button type="submit">Save Changes</button>
    </form>

    <hr>

    <h3>Change Password:</h3>
    <form action="Action" method="post">

        <label for="currentPassword">Current Password:</label>
        <input type="password" id="currentPassword" name="currentPassword" required>


        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required>


        <label for="confirmPassword">Confirm New Password:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required>

        <input type="hidden" name="action" value="passupdate">
        <button type="submit">Change Password</button>
    </form>
</div>
</body>
</html>
