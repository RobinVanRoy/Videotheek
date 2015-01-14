/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.Acteur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ikke
 */
public class ActeurServicesTest {
    
    public ActeurServicesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Save method, of class ActeurServices.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Acteur acteur = new Acteur("Bruce Test");
        ActeurServices.Save(acteur);        
        assertTrue(acteur.getActeurID()>0);
    }

    /**
     * Test of GetById method, of class ActeurServices.
     */
    @Test
    public void testGetById() {
        System.out.println("GetById");
        int Id = 9;
        Acteur result = ActeurServices.GetById(Id);
        assertTrue(result.getActeurID()==9);
    }

    /**
     * Test of GetAll method, of class ActeurServices.
     */
    @Test
    public void testGetAll() {
        System.out.println("GetAll");
        List<Acteur> result = ActeurServices.GetAll();
        assertTrue(result.size()>0);
    }

    /**
     * Test of GetByName method, of class ActeurServices.
     */
    @Test
    public void testGetByName() {
        System.out.println("GetByName");
        String naam = "George Clooney";
        List<Acteur> result = ActeurServices.GetByName(naam);
        assertTrue(result.size()>0);
    }

    /**
     * Test of Delete method, of class ActeurServices.
     */
//    @Test
//    public void testDelete() {
//        System.out.println("Delete");
//        //Bij elke test Id veranderen
//        int Id = 15;
//        ActeurServices.Delete(Id);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
//        EntityManager em = emf.createEntityManager();
//        assertTrue(em.createQuery("SELECT a FROM Acteur a WHERE a.acteurID = :acteurID").setParameter("acteurID", Id).getResultList().isEmpty());
//        em.close();
//        emf.close();                
//    }
    
}
