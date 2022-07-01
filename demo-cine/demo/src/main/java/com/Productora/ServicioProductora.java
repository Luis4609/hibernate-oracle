package com.Productora;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public class ServicioProductora {
    
    public static Productora findById(Session session, int id) {

        Productora productora = new Productora();

        productora = session.find(Productora.class, id);

        System.out.println("Productora devuelta con id: " + id + productora.toString());
        return productora;
    }
}
