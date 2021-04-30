/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_uebung;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerem
 */
public class FXMLControllerTest {
    private PersonJpaController pjc1;
    private PersonJpaController pjc2;
    
    public FXMLControllerTest() {
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("C_UebungDB1");
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("C_UebungDB2");
        pjc1 = new PersonJpaController(emf1);
        pjc2 = new PersonJpaController(emf2);
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
     * Test of buttonNachDB2 method, of class FXMLController.
     */
    @Test
    public void testButtonNachDB2() throws Exception {
        //hamcrest library hinzufuegen!
        //Generelles Ueberpruefen
        Person p = new Person(123, "Ich", "du");
            //Loeschen falls notwendig
        if(pjc1.findPerson(p.getId()) != null){
            pjc1.destroy(p.getId());
        }
        pjc1.create(p);
        Person testPerson = pjc1.findPerson(p.getId());
        assertEquals(testPerson.getId(), p.getId());
        
            //Loeschen falls notwendig
        if(pjc2.findPerson(p.getId()) != null){
            pjc2.destroy(p.getId());
        }
        testPerson = pjc2.findPerson(p.getId());
        assertEquals(testPerson, null);
       
        //Eigentliches Ueberpruefen der Methode
        FXMLController instance = new FXMLController();
        instance.buttonNachDB2(p, pjc1, pjc2);        
        testPerson = pjc2.findPerson(p.getId());
        assertEquals(testPerson.getId(), p.getId());        
        testPerson = pjc1.findPerson(p.getId());
        assertEquals(testPerson, null);
        
        //Loeschen der Test Personen
        if(pjc1.findPerson(p.getId()) != null){
            pjc1.destroy(p.getId());
        }
        if(pjc2.findPerson(p.getId()) != null){
            pjc2.destroy(p.getId());
        }
        
        System.out.println("Test testButtonNachDB2() erfolgreich");
    }

    /**
     * Test of buttonNachDB1 method, of class FXMLController.
     */
    @Test
    public void testButtonNachDB1() throws Exception {
        //Generelles Ueberpruefen
        Person p = new Person(456, "Ich", "du");
            //Loeschen falls notwendig
        if(pjc2.findPerson(p.getId()) != null){
            pjc2.destroy(p.getId());
        }
        pjc2.create(p);
        Person testPerson = pjc2.findPerson(p.getId());
        assertEquals(testPerson.getId(), p.getId());
        
            //Loeschen falls notwendig
        if(pjc1.findPerson(p.getId()) != null){
            pjc1.destroy(p.getId());
        }
        testPerson = pjc1.findPerson(p.getId());
        assertEquals(testPerson, null);
       
        //Eigentliches Ueberpruefen der Methode
        FXMLController instance = new FXMLController();
        instance.buttonNachDB1(p, pjc1, pjc2);        
        testPerson = pjc1.findPerson(p.getId());
        assertEquals(testPerson.getId(), p.getId());        
        testPerson = pjc2.findPerson(p.getId());
        assertEquals(testPerson, null);
        
        //Loeschen der Test Personen
        if(pjc2.findPerson(p.getId()) != null){
            pjc2.destroy(p.getId());
        }
        if(pjc1.findPerson(p.getId()) != null){
            pjc1.destroy(p.getId());
        }
        
        System.out.println("Test testButtonNachDB1() erfolgreich");
    }
    
}
