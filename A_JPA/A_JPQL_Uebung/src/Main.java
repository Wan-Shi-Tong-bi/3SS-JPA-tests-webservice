
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        
//        //als erstes Drag and Drop - dann Validate - um Daten in Tabelle zu halten
//        Kunde k = new Kunde("Huber", "Josef", LocalDate.now());
//        Girokonto gk = new Girokonto(1, 2, 3, 500, k);
//        Sparkonto sk = new Sparkonto(1, 300, k);
//        LinkedList<Konto> kontos = new LinkedList<Konto>();
//        kontos.add(gk);
//        kontos.add(sk);    
//        k.setKontos(kontos);
//        Buchung b1 = new Buchung('A', 200, "70 Euro wegen kaputtem Handy", sk);
//        LinkedList<Buchung> buchungen1 = new LinkedList<Buchung>();
//        buchungen1.add(b1);
//        gk.setBuchungen(buchungen1);
//        Buchung b2 = new Buchung('C', 20, "juhu", gk);
//        LinkedList<Buchung> buchungen2 = new LinkedList<Buchung>();
//        buchungen2.add(b2);
//        sk.setBuchungen(buchungen2);
//        
//        
//        
//        em.getTransaction().begin();
//        em.persist(k);
//        em.persist(gk);
//        em.persist(sk);
//        em.persist(b1);
//        em.persist(b2);
//        em.getTransaction().commit();
//        
        Query query = em.createQuery("select b from Buchung b");
            List<Buchung> list = query.getResultList();
            System.out.println("" + list.get(0).getArt());
            System.out.println("" + list.get(1).getArt());
            
        Query query1 = em.createQuery("Select MAX(k.kontostand) from Konto k");
        int result = (int ) query1.getSingleResult();
            System.out.println("" + result);
    
        Query query2 = em.createQuery("Select UPPER(e.text) from Buchung e");
        List<String> list2 = query2.getResultList();
            System.out.println("" + list2.get(0));
            System.out.println("" + list2.get(1));
        
        Query qu = em.createQuery("Select b,k from Buchung b, Konto k where b.id=1");
//        List<Object[]> tupel = qu.getResultList();
//            System.out.println("" + tupel.get(0));
            //geht nicht wegen Daten in Tabelle
            
        qu = em.createQuery("Select b.id from Buchung b where b.id BETWEEN 4 AND 10");
        List<Integer> tupel1 = qu.getResultList();
            System.out.println("" + tupel1.get(0));
            System.out.println("" + tupel1.get(1));
        
        qu = em.createQuery("Select b.id from Buchung b where b.text Like '%70%'");
            tupel1 = qu.getResultList();
            System.out.println("" + tupel1.get(0));
            
        qu = em.createQuery("Select b.id from Buchung b order by b.id desc");
            tupel1 = qu.getResultList();
            System.out.println("" + tupel1.get(0));
    }
    
}
