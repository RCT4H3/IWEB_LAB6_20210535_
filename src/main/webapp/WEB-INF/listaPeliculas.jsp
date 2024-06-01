<%@ page import="org.example.l6_20210535.Beans.PeliculaB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    ArrayList<PeliculaB> lista = (ArrayList<PeliculaB>) request.getAttribute("lista");
    String queryBusqueda = request.getParameter("queryBusqueda") != null ? request.getParameter("queryBusqueda") : "";
%>
<% DecimalFormat formato = new DecimalFormat("#,###"); %>
<html>
<head>
    <title>Lista de Películas</title>
</head>
<body>
<h1>Lista de películas</h1>

<form action="PeliculaServlet" method="get">
    <input type="text" id="queryBusqueda" name="queryBusqueda" value="<%= queryBusqueda %>" placeholder="Buscar película...">
    <input type="submit" value="Buscar">
</form>

<table border="1">
    <tr>
        <th>Título</th>
        <th>Director</th>
        <th>Año Publicación</th>
        <th>Rating</th>
        <th>BoxOffice</th>
        <th>Género</th>
        <th>Actores</th>
    </tr>
    <% for (PeliculaB peliculaB : lista) { %>
    <tr>
        <td><a href="DetalleServlet?idPelicula=<%= peliculaB.getIdPelicula() %>"><%= peliculaB.getTitulo() %></a></td>
        <td><%= peliculaB.getDirector() %></td>
        <td><%= peliculaB.getAnoPublicacion() %></td>
        <td><%= String.valueOf(peliculaB.getRating()) %>/10</td>
        <td>$ <%= formato.format(peliculaB.getBoxOffice()) %></td>
        <td><%= peliculaB.getGenero() %></td>
        <td><a href="ActorServlet?idPelicula=<%= peliculaB.getIdPelicula() %>">Ver actores</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>
