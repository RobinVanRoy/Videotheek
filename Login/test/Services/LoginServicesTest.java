/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.Login;
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
public class LoginServicesTest {
    
    public LoginServicesTest() {
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
     * Test of Save method, of class LoginServices.
     */
    @Test
    public void testSave() {
        System.out.println("Save");
        Login login = new Login("AdminTest","passWord");
        LoginServices.Save(login);
        assertTrue(login.getId()>0);        
    }

    /**
     * Test of GetByUserName method, of class LoginServices.
     */
    @Test
    public void testGetByUserName() {
        System.out.println("GetByUserName");
        String userName = "AdminTest";        
        Login result = LoginServices.GetByUserName(userName);
        assertTrue("Admin".equals(result.getUserName()));
    }

    /**
     * Test of Delete method, of class LoginServices.
     */
    @Test
    public void testDelete() {
        System.out.println("Delete");
        String userName = "AdminTest";
        LoginServices.Delete(userName);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LoginPU");
        EntityManager em = emf.createEntityManager();
        assertTrue(em.createQuery("SELECT l FROM Login l WHERE l.userName = :userName").setParameter("userName", userName).getResultList().isEmpty());
        em.close();
        emf.close();
        
    }
    
}
