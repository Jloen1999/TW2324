<%@page import="es.unex.cum.tw" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.util.**" %>

<div class="container">
    <h2>Datos de la BD</h2>
    <div class="container2">
        <%
            BooksServiceBD b_service = new BooksServiceBD();
            List<Book> books = b_service.getListOfBooks();
            if (books != null && !books.isEmpty()) {
                // Accede a los elementos de la lista
                for (Book book : books) {
                    int id = book.getID_book();
        %>
        <img src="<%=book.getImage()%>" alt="Book image" class="img-fluid rounded">
        <p>
            <strong>Title:</strong>
            <%=book.getTitle()%>
        </p>
        <p>
            <strong>Author:</strong>
            <%=book.getAuthor()%>
        </p>
        <hr>
        <%
                }
            } else {
                // La lista est� vac�a o es nula
                out.println("No books found.");
            }%>
    </div>
</div>
