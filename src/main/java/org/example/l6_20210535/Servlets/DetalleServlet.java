package org.example.l6_20210535.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.l6_20210535.Beans.ActoresB;
import org.example.l6_20210535.Beans.PeliculaB;
import org.example.l6_20210535.Daos.PeliculaDao;

import java.io.IOException;

@WebServlet(name = "DetalleServlet", value = "/DetalleServlet")
public class DetalleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        PeliculaDao pDao = new PeliculaDao();
        PeliculaB pelicula = pDao.obtenerPeliculaPorId(idPelicula);

        String vista = "WEB-INF/viewPelicula.jsp";
        request.setAttribute("pelicula", pelicula);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
