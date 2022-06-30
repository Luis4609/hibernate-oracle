package com.Song;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class SongService {

    public static void add(Session session, int id, String name, String singer) {

        //
        Song song1 = new Song();

        song1.setId(id);
        song1.setSongName(name);
        song1.setSinger(singer);

        session.beginTransaction();

        // Here we have used
        // save() method of JPA
        session.save(song1);

        session.getTransaction().commit();

        System.out.println("Song añadido");

    }

    public static Song findById(Session session, int id) {

        Song song = new Song();

        song = session.find(Song.class, id);

        System.out.println("Song devuelta con id: " + id + song.toString());
        return song;
    }

    public static List<Song> findAll(Session session) {

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Song> sq = cb.createQuery(Song.class);
        Root<Song> rootEntry = sq.from(Song.class);

        CriteriaQuery<Song> all = sq.select(rootEntry);

        TypedQuery<Song> allSongs = session.createQuery(all);

        return allSongs.getResultList();
    }

    public static void update(Session session, int id, String name, String singer) {

        if (findById(session, id) == null) {
            return;
        }
        Song song = findById(session, id);

        song.setSongName(name);
        song.setSinger(singer);

        session.beginTransaction();

        // Here we have used
        // save() method of JPA
        // session.save(song);
        session.update(song);

        session.getTransaction().commit();

        System.out.println("Song update");

    }

    public static boolean delete(Session session, int id) {

        if (findById(session, id) == null) {
            return false;
        }

        Song song = findById(session, id);
        session.beginTransaction();

        session.delete(song);

        session.getTransaction().commit();

        System.out.println("Song delete");

        return true;
    }

    public static List<Song> paginate(Session session) {

        Query query = session.createQuery("From Song");
        query.setFirstResult(0);
        query.setMaxResults(10);

        List<Song> songList = query.getResultList();

        System.out.println("Paginando!!!!");
        return songList;

    }

    public static List<Song> orderByArtist(Session session) {

        String jql = "SELECT singer, songid, songname FROM song order by singer DESC";
        Query query = session.createQuery(jql);

        List<Song> songs = query.getResultList();

        return songs;
    }

    public static List<Order> orderByAtributte(Session session, String atributte) {

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Song> criteriaQuery = criteriaBuilder.createQuery(Song.class);

        Root<Song> from = criteriaQuery.from(Song.class);

        CriteriaQuery<Song> select = criteriaQuery.select(from);
        // criteriaQuery.orderBy(criteriaBuilder.asc(from.get("name")));

        List<Order> songs = criteriaQuery.orderBy(criteriaBuilder.asc(from.get(atributte))).getOrderList();
        return songs;
    }


    public static int getCountSongs(Session session){

        int count = 0;

       // @Query(value = 'SELECT COUNT(*) FROM song', NativeQuery = true)

        return count;
    }
}
