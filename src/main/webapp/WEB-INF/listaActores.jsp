<%@ page import="org.example.l6_20210535.Beans.ActoresB" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<ActoresB> lista = (ArrayList<ActoresB>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <%ActoresB aB = lista.get(0);%>
    <td><%= aB.getTitulo() %></td>
</h1>
<table border="1">
    <tr>
        <th>idActor</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Año de Nacimiento</th>
        <th>Ganador Premio Oscar</th>

    </tr>
    <% for (ActoresB actoresB : lista){%>
    <tr>


        <td><%= actoresB.getIdActor() %></td>
        <td><%=actoresB.getNombre() %></td>
        <td><%=actoresB.getApellido() %></td>
        <td><%=actoresB.getAnoNacimiento() %></td>
        <td><%=actoresB.isPremioOscar()%></td>

    </tr>
    <% }%>
</table>
</body>
</html>
