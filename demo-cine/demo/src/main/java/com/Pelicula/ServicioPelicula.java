package com.Pelicula;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class ServicioPelicula {

    public static Pelicula findById(Session session, int id) {

        Pelicula pelicula = new Pelicula();

        pelicula = session.find(Pelicula.class, id);

        System.out.println("Pelicula devuelta con id: " + id + pelicula.toString());
        return pelicula;
    }

    public static List<Pelicula> getAll(Session session) {

        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = session
                .createNamedQuery("pelicula.getAll", Pelicula.class)
                .getResultList();

        return peliculas;
    }

    public static List<Pelicula> getPeliculasByGenero(Session session, String genero) {

        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = session
                .createNamedQuery("pelicula.byGenero", Pelicula.class)
                .setParameter("genero", genero)
                .getResultList();

        return peliculas;
    }

    public static List<Pelicula> getPeliculasByDirector(Session session, String director) {

        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = session
                .createNamedQuery("pelicula.byDirector", Pelicula.class)
                .setParameter("director", director)
                .getResultList();

        return peliculas;
    }

    public static List<Object[]> getPeliculasJoinDirectorWhere(Session session, String director) {

        List<Object[]> peliculas = new ArrayList<Object[]>();
        peliculas = session
                .createNamedQuery("pelicula.join.director.where", Object[].class)
                .setParameter("nombre", director)
                .getResultList();

        return peliculas;
    }

    public static List<Object[]> getPeliculasGroupByHaving(Session session) {

        List<Object[]> peliculas = new ArrayList<Object[]>();
        peliculas = session
                .createNamedQuery("pelicula.groupBy.having", Object[].class)
                .getResultList();

        return peliculas;
    }

}
