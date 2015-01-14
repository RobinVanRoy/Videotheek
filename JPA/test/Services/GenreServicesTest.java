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
public class GenreServicesTest {
    
    public GenreServicesTest() {
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
     * Test of Save method, of class GenreServices.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Genre genre = new Genre("TestGenre");
        GenreServices.Save(genre);
        assertTrue(genre.getGenreID()>0);
    }

    /**
     * Test of GetById method, of class GenreServices.
     */
    @Test
    public void testGetById() {
        System.out.println("GetById");
        int Id = 5;
        Genre result = GenreServices.GetById(Id);
        assertTrue(result.getGenreID() == 5);
    }

    /**
     * Test of GetAll method, of class GenreServices.
     */
    @Test
    public void testGetAll() {
        System.out.println("GetAll");
        List<Genre> result = GenreServices.GetAll();
        assertTrue(result.size()>0);
    }

    /**
     * Test of Delete method, of class GenreServices.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        int Id = 29;
        GenreServices.Delete(Id);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        assertTrue(em.createQuery("SELECT g FROM Genre g WHERE g.genreID = :genreID").setParameter("genreID", Id).getResultList().isEmpty());
        em.close();
        emf.close();
    }
    
}
