package com.main;

import java.util.Arrays;
import java.util.List;

// Java Program to Illustrate App File
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Pelicula.ServicioPelicula;
import com.Song.Song;

// Main class
public class App {

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

		// Create songs
		// SongService.add(session, 50, "High Way", "Metalica");

		// FindById
		// SongService.findById(session, 10);

		// FindAll
		// System.out.println(SongService.findAll(session).toString());
		// SongService.update(session, 10, "Cancion 10", "Update singer");

		// Delete
		// SongService.delete(session, 20);

		// System.out.println(SongService.paginate(session).toString());

		// System.out.println(SongService.orderByArtist(session).toString());

		// System.out.println(SongService.orderByAtributte(session,
		// "singer").toString());

		// Pelicula
		// System.out.println(ServicioPelicula.findById(session, 1));

		// System.out.println(ServicioProductora.findById(session, 1));

		// System.out.println(ServicioDirector.findById(session, 1));

		// System.out.println(ServicioPelicula.getAll(session));
		// System.out.println(ServicioPelicula.getPeliculasByGenero(session, "Ciencia
		// Ficción"));

		// System.out.println(ServicioPelicula.getPeliculasByDirector(session, "Guy
		// Ritchie"));

		// List<Object[]> peliculasBuDirectorList =
		// ServicioPelicula.getPeliculasJoinDirectorWhere(session, "Guy Ritchie");

		// for (Object[] p : peliculasBuDirectorList) {
		// System.out.println(Arrays.toString(p));

		// }

		List<Object[]> peliculasWithHaving = ServicioPelicula.getPeliculasGroupByHaving(session);

		for (Object[] p : peliculasWithHaving) {
			System.out.println(Arrays.toString(p));
		}

	}
}
