package com.Director;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class ServicioDirector {

    public static Director findById(Session session, int id) {

        Director director = new Director();

        director = session.find(Director.class, id);

        System.out.println("Director devuelta con id: " + id + director.toString());
        return director;
    }

    public static List<Director> findAll(Session session) {

        List<Director> directors = new ArrayList<Director>();
        directors = session
                .createNamedQuery("Director.getAll", Director.class)
                .getResultList();

        return directors;
    }
}
