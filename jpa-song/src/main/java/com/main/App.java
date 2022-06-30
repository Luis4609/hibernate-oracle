package com.main;

// Java Program to Illustrate App File
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Song.Song;
import com.Song.SongService;

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
		//SongService.findById(session, 10);

		// FindAll
		//System.out.println(SongService.findAll(session).toString());
		// SongService.update(session, 10, "Cancion 10", "Update singer");

		// Delete
		// SongService.delete(session, 20);

		System.out.println(SongService.paginate(session).toString());

		// System.out.println(SongService.orderByArtist(session).toString());

		//System.out.println(SongService.orderByAtributte(session, "singer").toString());
	}
}
