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
public class FilmServicesTest {
    
    public FilmServicesTest() {
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
     * Test of Save method, of class FilmServices.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Film film = new Film("TestFilm5", "Actie", "Actiefilm", 2014, "Brad Pitt, Angelina Jolie", false);
        FilmServices.Save(film);
        assertTrue(film.getFilmID()>0);
    }

    /**
     * Test of GetById method, of class FilmServices.
     */
    @Test
    public void testGetById() {
        System.out.println("GetById");
        int Id = 9;
        Film result = FilmServices.GetById(Id);
        assertTrue(result.getFilmID()==9);
    }

    /**
     * Test of GetAll method, of class FilmServices.
     */
    @Test
    public void testGetAll() {
        System.out.println("GetAll");
        List<Film> result = FilmServices.GetAll();
        assertTrue(result.size()>0);
    }

    /**
     * Test of Delete method, of class FilmServices.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        //bij elke test Id veranderen
        int Id = 13;
        FilmServices.Delete(Id);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");
        EntityManager em = emf.createEntityManager();
        assertTrue(em.createQuery("SELECT f FROM Film f WHERE f.filmID = :filmID").setParameter("filmID", Id).getResultList().isEmpty());
        em.close();
        emf.close();
        
    }

    /**
     * Test of Lenen method, of class FilmServices.
     */
    @Test
    public void testLenen() {
        System.out.println("Lenen");
        int Id = 9;
        boolean b = true;
        Film result = FilmServices.Lenen(Id, b);
        assertTrue(result.getUitgeleend() == true);
    }
    
}
