/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_jpa_b_uebung;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Person;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfWohnort;
    @FXML
    private Button button;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("A_JPA_C_UebungPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction t = em.getTransaction();
//        t.begin();
//        
//        em.persist(new Person(tfName.getText(), tfWohnort.getText()));
//        t.commit();
        
    }    

    @FXML
    private void handleButtonClicked(MouseEvent event) {
        
    }
    
}
