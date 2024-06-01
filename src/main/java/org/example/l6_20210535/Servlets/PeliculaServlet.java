package org.example.l6_20210535.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.l6_20210535.Beans.PeliculaB;
import org.example.l6_20210535.Daos.PeliculaDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PeliculaDao pDao = new PeliculaDao();
        String queryBusqueda = request.getParameter("queryBusqueda");
        ArrayList<PeliculaB> list;
        if (queryBusqueda != null && !queryBusqueda.trim().isEmpty()) {
            list = pDao.buscarPorTitulo(queryBusqueda);
        } else {
            list = pDao.listar();
        }
        String vista = "WEB-INF/listaPeliculas.jsp";
        request.setAttribute("lista", list);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
