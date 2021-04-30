
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Buchung;
import model.Girokonto;
import model.Konto;
import model.Kunde;
import model.Sparkonto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("C_A_Mapp_B_UebungPU");
        EntityManager em = emf.createEntityManager();
        
        Kunde k = new Kunde("Huber", "Josef", LocalDate.now());
        Girokonto gk = new Girokonto(1, 2, 3, 500, k);
        Sparkonto sk = new Sparkonto(1, 300, k);
        LinkedList<Konto> kontos = new LinkedList<Konto>();
        kontos.add(gk);
        kontos.add(sk);    
        k.setKontos(kontos);
        Buchung b1 = new Buchung('A', 200, "70 Euro wegen kaputtem Handy", sk);
        LinkedList<Buchung> buchungen1 = new LinkedList<Buchung>();
        buchungen1.add(b1);
        gk.setBuchungen(buchungen1);
        Buchung b2 = new Buchung('C', 20, "juhu", gk);
        LinkedList<Buchung> buchungen2 = new LinkedList<Buchung>();
        buchungen2.add(b2);
        sk.setBuchungen(buchungen2);
        
        
        
        em.getTransaction().begin();
        em.persist(k);
        em.persist(gk);
        em.persist(sk);
        em.persist(b1);
        em.persist(b2);
        em.getTransaction().commit();
    }
    
}
