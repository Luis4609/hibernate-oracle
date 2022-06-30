package com.Programa;

// Java Program to Illustrate App File
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Planta.ServicioPlanta;
import com.Song.Song;

public class ProgramaPlanta {

    // Main driver method
    public static void main(String[] args) {

        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);

        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Initialize Session Object
        Session session = sessionFactory.openSession();

        ServicioPlanta.createPlanta(session, 3, "Pepino", "Planta");

    }
}
