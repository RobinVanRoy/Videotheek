/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ikke
 */
public class ActeurServices {
    
    public static void Save(Acteur acteur){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        em.persist(acteur);
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Acteur GetById(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Acteur.findByActeurID", Acteur.class).setParameter("acteurID", Id);
        Acteur acteur = (Acteur)q.getSingleResult();
        em.close();
        emf.close();
        return acteur;
    }
    
    public static List<Acteur> GetAll(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Acteur.findAll",Acteur.class);
        List<Acteur> list = q.getResultList();
        em.close();
        emf.close();
        return list;
    }
    
    public static List<Acteur> GetByName(String naam){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Acteur.findByNaam",Acteur.class).setParameter("naam", naam);
        List<Acteur> list = q.getResultList();
        em.close();
        emf.close();
        return list;
    }
    
    public static void Delete(int Id){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        Query q = em.createNamedQuery("Acteur.findByActeurID", Acteur.class).setParameter("acteurID", Id);
        Acteur acteur = (Acteur)q.getSingleResult();
        trans.begin();
        em.remove(acteur);
        trans.commit();
        em.close();
        emf.close();
    }
    
}
