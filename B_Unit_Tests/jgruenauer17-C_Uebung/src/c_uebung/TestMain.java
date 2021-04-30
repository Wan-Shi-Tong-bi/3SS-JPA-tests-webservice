/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_uebung;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Person;

/**
 *
 * @author jerem
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("C_UebungDB1");
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("C_UebungDB2");
        PersonJpaController pjc1 = new PersonJpaController(emf1);
        PersonJpaController pjc2 = new PersonJpaController(emf2);
        
        Person p1 = new Person(1, "Thomas", "H");
        Person p2 = new Person(2, "Leander", "B");
        Person p3 = new Person(3, "Mathias", "H");
        Person p4 = new Person(4, "Markus", "P");
        Person p5 = new Person(5, "Thomas", "N");
        Person p6 = new Person(6, "David", "S");
        
        pjc1.create(p1);
        pjc1.create(p2);
        pjc1.create(p3);
        pjc2.create(p4);
        pjc2.create(p5);
        pjc2.create(p6);
    }
}
