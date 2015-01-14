/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.Genre;
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
public class GenreServices {
    
    public static void Save(Genre genre){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        em.persist(genre);
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Genre GetById(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Genre.findByGenreID", Genre.class).setParameter("genreID", Id);
        Genre genre = (Genre)q.getSingleResult();
        em.close();
        emf.close();
        return genre;
    }
    
    public static List<Genre> GetAll(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Genre.findAll", Genre.class);
        List<Genre> list = q.getResultList();
        em.close();
        emf.close();
        return list;
    }
    
    public static void Delete(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        Query q = em.createNamedQuery("Genre.findByGenreID", Genre.class).setParameter("genreID", Id);
        Genre genre = (Genre)q.getSingleResult();
        trans.begin();
        em.remove(genre);
        trans.commit();
        em.close();
        emf.close();
    }
    
}
