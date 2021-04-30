/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_mapp_c_uebung;

import a_mapp_c_uebung.model.Adresse;
import a_mapp_c_uebung.model.Person;
import a_mapp_c_uebung.model.Termin;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jerem
 */
public class A_Mapp_C_Uebung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("A_Mapp_C_UebungPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Adresse ad = new Adresse("Urnenweg", 4710);
        Person p = new Person("Huber", "Franz", ad);
        Termin t = new Termin("ImpotantDate", p);
        Person p1 = new Person("Jan", "Jan", ad);
        Person p2 = new Person("Bullteon", "Gustav", ad);
        LinkedList<Person> l = new LinkedList<Person>();
        l.add(p1);
        l.add(p2);
        t.setTeilnehmer(l);
        
        em.persist(t);
        em.persist(p);
        em.getTransaction().commit();
        
    }
    
}
