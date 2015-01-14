/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ikke
 */
public class LoginServices {
    
    public static void Save(Login login){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        trans.begin();
        em.persist(login);
        trans.commit();
        em.close();
        emf.close();
    }
    
    public static Login GetByUserName(String userName){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginPU");
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createNamedQuery("Login.findByUserName", Login.class).setParameter("userName", userName);
        Login login = (Login)q.getSingleResult();
        em.close();
        emf.close();
        return login;        
    }
    
    public static void Delete(String userName){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        Query q = em.createNamedQuery("Login.findByUserName", Login.class).setParameter("userName", userName);
        Login login = (Login)q.getSingleResult();
        trans.begin();
        em.remove(login);
        trans.commit();
        em.close();
        emf.close();
    }
}
