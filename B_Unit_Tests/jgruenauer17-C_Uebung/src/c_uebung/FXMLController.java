/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c_uebung;

import c_uebung.exceptions.NonexistentEntityException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Person;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private Button buttonNachDB2;
    @FXML
    private Button ButtonNachDB1;
    @FXML
    private ListView<Person> list1;
    @FXML
    private ListView<Person> list2;
    private PersonJpaController pjc1;
    private PersonJpaController pjc2;
    @FXML
    private TableView<Person> table1;
    @FXML
    private TableColumn<Person, Integer> id1;
    @FXML
    private TableColumn<Person, String> vor1;
    @FXML
    private TableColumn<Person, String> nach1;
    @FXML
    private TableView<Person> table2;
    @FXML
    private TableColumn<Person, Integer> id2;
    @FXML
    private TableColumn<Person, String> vor2;
    @FXML
    private TableColumn<Person, String> nach2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("C_UebungDB1");
        EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("C_UebungDB2");
        pjc1 = new PersonJpaController(emf1);
        pjc2 = new PersonJpaController(emf2);
        
        //fuer ListView
//        list1.getItems().setAll(pjc1.findPersonEntities());
//        list2.getItems().setAll(pjc2.findPersonEntities());
        
        //fuer Table View
        id1.setCellValueFactory(new PropertyValueFactory<>("id"));
        id2.setCellValueFactory(new PropertyValueFactory<>("id"));
        vor1.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        vor2.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        nach1.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        nach2.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        table1.getItems().setAll(pjc1.findPersonEntities());
        table2.getItems().setAll(pjc2.findPersonEntities());
    }    

    @FXML
    private void handleButtonNachDB2(ActionEvent event) throws NonexistentEntityException, Exception {
        //eigentlich mit TableView - so gehts aber einfacher
        //fuer ListView
//        Person p = list1.getSelectionModel().getSelectedItem();
//        buttonNachDB2(p, pjc1, pjc2);       
//        list1.getItems().setAll(pjc1.findPersonEntities());
//        list2.getItems().setAll(pjc2.findPersonEntities());
        
        //fuer TableView
        Person p2 = table1.getSelectionModel().getSelectedItem();
        buttonNachDB2(p2, pjc1, pjc2);       
        table1.getItems().setAll(pjc1.findPersonEntities());
        table2.getItems().setAll(pjc2.findPersonEntities());
    }

    public void buttonNachDB2(Person p, PersonJpaController pc1, PersonJpaController pc2) throws NonexistentEntityException, Exception{
        pc1.destroy(p.getId());
        pc2.create(p);
    }
    
    @FXML
    private void handleButtonNachDB1(ActionEvent event) throws NonexistentEntityException, Exception {
        //fuer ListView
//        Person p = list2.getSelectionModel().getSelectedItem();
//        buttonNachDB1(p, pjc1, pjc2);       
//        list1.getItems().setAll(pjc1.findPersonEntities());
//        list2.getItems().setAll(pjc2.findPersonEntities());
        
        //fuer TableView
        Person p2 = table2.getSelectionModel().getSelectedItem();
        buttonNachDB1(p2, pjc1, pjc2);       
        table1.getItems().setAll(pjc1.findPersonEntities());
        table2.getItems().setAll(pjc2.findPersonEntities());
    }
    
    public void buttonNachDB1(Person p, PersonJpaController pc1, PersonJpaController pc2) throws NonexistentEntityException, Exception{
        pc2.destroy(p.getId());
        pc1.create(p);
    }
    
}
