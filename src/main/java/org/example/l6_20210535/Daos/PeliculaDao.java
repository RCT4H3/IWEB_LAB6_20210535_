package org.example.l6_20210535.Daos;

import org.example.l6_20210535.Beans.ActoresB;
import org.example.l6_20210535.Beans.PeliculaB;

import java.sql.*;
import java.util.AbstractCollection;
import java.util.ArrayList;

public class PeliculaDao {
    public ArrayList<PeliculaB> listar(){
        ArrayList<PeliculaB> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT " +
                "p.idPelicula, " +
                "p.titulo, " +
                "p.director, " +
                "p.anoPublicacion, " +
                "p.rating, " +
                "p.boxOffice, " +
                "g.nombre AS genero " +
                "FROM Pelicula p " +
                "JOIN Genero g ON p.idGenero = g.idGenero " +
                "ORDER BY p.rating DESC, p.boxOffice DESC;";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {

                PeliculaB peliculas = new PeliculaB();
                peliculas.setIdPelicula(rs.getInt(1));
                peliculas.setTitulo(rs.getString(2));
                peliculas.setDirector(rs.getString(3));
                peliculas.setAnoPublicacion(rs.getString(4));
                peliculas.setRating(rs.getDouble(5));
                peliculas.setBoxOffice(rs.getDouble(6));
                peliculas.setGenero(rs.getString(7));

                lista.add(peliculas);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public PeliculaB obtenerPeliculaPorId(int idPelicula) {
        PeliculaB pelicula = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT " +
                "p.idPelicula, " +
                "p.titulo, " +
                "p.director, " +
                "p.anoPublicacion, " +
                "p.rating, " +
                "p.boxOffice, " +
                "g.nombre AS genero " +
                "FROM Pelicula p " +
                "JOIN Genero g ON p.idGenero = g.idGenero " +
                "WHERE p.idPelicula = ?;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPelicula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pelicula = new PeliculaB();
                    pelicula.setIdPelicula(rs.getInt("idPelicula"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnoPublicacion(rs.getString("anoPublicacion"));
                    pelicula.setRating(rs.getDouble("rating"));
                    pelicula.setBoxOffice(rs.getDouble("boxOffice"));
                    pelicula.setGenero(rs.getString("genero"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pelicula;
    }
    public ArrayList<ActoresB> listarActores(int idPelicula) {
        ArrayList<ActoresB> lista = new ArrayList<>();
        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT " +
                "p.idPelicula, " +
                "pel.titulo AS tituloPelicula, " +
                "a.idActor, " +
                "a.Nombre, " +
                "a.Apellido, " +
                "a.anoNacimiento, " +
                "a.premioOscar " +
                "FROM Protagonistas p " +
                "JOIN Actor a ON p.idActor = a.idActor " +
                "JOIN Pelicula pel ON p.idPelicula = pel.idPelicula " +
                "WHERE p.idPelicula = ?;";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idPelicula);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ActoresB actoresB = new ActoresB();
                    actoresB.setTitulo(rs.getString(2));
                    actoresB.setIdActor(rs.getInt(3));
                    actoresB.setNombre(rs.getString(4));
                    actoresB.setApellido(rs.getString(5));
                    actoresB.setAnoNacimiento(rs.getString(6));
                    actoresB.setPremioOscar(rs.getBoolean(7));


                    lista.add(actoresB);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public ArrayList<PeliculaB> buscarPorTitulo(String titulo) {
        ArrayList<PeliculaB> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/mydb";
        String sql = "SELECT " +
                "p.titulo, " +
                "p.director, " +
                "p.anoPublicacion, " +
                "p.rating, " +
                "p.boxOffice, " +
                "g.nombre AS genero " +
                "FROM Pelicula p " +
                "JOIN Genero g ON p.idGenero = g.idGenero " +
                "WHERE LOWER(p.titulo) LIKE LOWER(CONCAT('%', ?, '%')) " +
                "ORDER BY p.rating DESC, p.boxOffice DESC;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, titulo);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    PeliculaB peliculas = new PeliculaB();
                    peliculas.setTitulo(rs.getString(1));
                    peliculas.setDirector(rs.getString(2));
                    peliculas.setAnoPublicacion(rs.getString(3));
                    peliculas.setRating(rs.getDouble(4));
                    peliculas.setBoxOffice(rs.getDouble(5));
                    peliculas.setGenero(rs.getString(6));

                    lista.add(peliculas);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
