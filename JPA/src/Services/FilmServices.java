/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.Film;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ikke
 */
public class FilmServices {
    
    public static void Save(Film film){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        em.persist(film);
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Film GetById(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Film.findByFilmID", Film.class).setParameter("filmID", Id);
        Film film = (Film)q.getSingleResult();
        em.close();
        emf.close();
        return film;
    }
    
    public static List<Film> GetAll(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Film.findAll", Film.class);
        List<Film> list = q.getResultList();
        em.close();
        emf.close();
        return list;
    }
    
    public static void Delete(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        Query q = em.createNamedQuery("Film.findByFilmID", Film.class).setParameter("filmID", Id);
        Film film = (Film)q.getSingleResult();
        trans.begin();
        em.remove(film);
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Film Lenen(int Id, boolean b){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        Query q = em.createNamedQuery("Film.findByFilmID", Film.class).setParameter("filmID", Id);
        Film film = (Film)q.getSingleResult();
        film.setUitgeleend(b);
        trans.begin();
        em.persist(film);
        trans.commit();
        em.close();
        emf.close();
        return film;
    }
    
}
