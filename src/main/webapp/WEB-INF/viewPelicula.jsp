<%@ page import="org.example.l6_20210535.Beans.PeliculaB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.DecimalFormat" %>
<%
    PeliculaB pelicula = (PeliculaB) request.getAttribute("pelicula");
%>
<% DecimalFormat formato = new DecimalFormat("#,###"); %>
<html>
<head>
    <title><%= pelicula.getTitulo() %></title>
</head>
<body>
<h1><%= pelicula.getTitulo() %></h1>
<table border="1">
    <tr>
        <th>ID Película</th>
        <td><%= pelicula.getIdPelicula() %></td>
    </tr>
    <tr>
        <th>Título</th>
        <td><%= pelicula.getTitulo() %></td>
    </tr>
    <tr>
        <th>Director</th>
        <td><%= pelicula.getDirector() %></td>
    </tr>
    <tr>
        <th>Año Publicación</th>
        <td><%= pelicula.getAnoPublicacion() %></td>
    </tr>
    <tr>
        <th>Rating</th>
        <td><%= String.valueOf(pelicula.getRating()) %>/10</td>
    </tr>
    <tr>
        <th>Box Office</th>
        <td>$ <%= formato.format(pelicula.getBoxOffice()) %></td>
    </tr>
    <tr>
        <th>Género</th>
        <td><%= pelicula.getGenero() %></td>
    </tr>
    <tr>
        <th>Actores</th>
        <td><a href="ActorServlet?idPelicula=<%= pelicula.getIdPelicula()%>">Ver actores</a></td>
    </tr>
</table>
<br>
<a href="PeliculaServlet">Volver a la lista de películas</a>
</body>
</html>
