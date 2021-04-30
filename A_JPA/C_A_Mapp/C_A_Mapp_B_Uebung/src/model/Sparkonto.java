/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jerem
 */
@Entity
@DiscriminatorValue("1")
public class Sparkonto extends Konto implements Serializable {

    private static final long serialVersionUID = 1L;
    private int zinssatz;

    public Sparkonto(int zinssatz, int kontostand, Kunde istKonto) {
        super(kontostand, istKonto);
        this.zinssatz = zinssatz;
    }

    public Sparkonto() {
        super();
    }

    public int getZinssatz() {
        return zinssatz;
    }

    public void setZinssatz(int zinssatz) {
        this.zinssatz = zinssatz;
    }
    
}
