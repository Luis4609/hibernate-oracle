package com.Planta;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ServicioPlanta {

    public static void createPlanta(Session session, int id, String nombre, String tipo) {

        Planta planta = new Planta();

        planta.setId(id);
        planta.setNombre(nombre);
        planta.setTipo(tipo);

        session.beginTransaction();

        // Here we have used
        // save() method of JPA
        session.save(planta);

        session.getTransaction().commit();

        System.out.println("Planta añadida: " + planta.toString());
    }

    public static Planta buscarPlanta(int id) {

        Planta planta = new Planta();

        return planta;
    }

    public static void buscarTodasLasPlantas() {

    }

    // public static void update(Session session, int id, String nombre, String tipo) {

    //     List<Planta> plantas = session.createQuery("from Planta").getResultList();

    //     Transaction transaction = session.getTransaction();
    //     transaction.begin();

    //     Planta planta = plantas.stream()
    //             .filter(p -> p.getId() == 3)
    //             .findFirst()
    //             .get();

    //     planta.setNombre("Gianluigi Buffon");
    //     transaction.commit();

    // }

}
