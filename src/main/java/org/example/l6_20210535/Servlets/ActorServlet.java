package org.example.l6_20210535.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.l6_20210535.Beans.ActoresB;
import org.example.l6_20210535.Beans.PeliculaB;
import org.example.l6_20210535.Daos.PeliculaDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class ActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
        PeliculaDao pDao = new PeliculaDao();
        ArrayList<ActoresB> list = pDao.listarActores(idPelicula);
        String vista = "WEB-INF/listaActores.jsp";
        request.setAttribute("lista", list);
        RequestDispatcher rd = request.getRequestDispatcher(vista);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
