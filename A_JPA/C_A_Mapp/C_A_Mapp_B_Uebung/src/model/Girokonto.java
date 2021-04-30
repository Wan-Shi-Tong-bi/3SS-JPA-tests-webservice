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
@DiscriminatorValue("2")
public class Girokonto extends Konto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int ueberziehungskredit;
    private int zinssatzGuthaben;
    private int inssatzKredit;

    public Girokonto(int ueberziehungskredit, int zinssatzGuthaben, int inssatzKredit, int kontostand, Kunde istKonto) {
        super(kontostand, istKonto);
        this.ueberziehungskredit = ueberziehungskredit;
        this.zinssatzGuthaben = zinssatzGuthaben;
        this.inssatzKredit = inssatzKredit;
    }

    public Girokonto() {
        super();
    }

    public int getUeberziehungskredit() {
        return ueberziehungskredit;
    }

    public void setUeberziehungskredit(int ueberziehungskredit) {
        this.ueberziehungskredit = ueberziehungskredit;
    }

    public int getZinssatzGuthaben() {
        return zinssatzGuthaben;
    }

    public void setZinssatzGuthaben(int zinssatzGuthaben) {
        this.zinssatzGuthaben = zinssatzGuthaben;
    }

    public int getInssatzKredit() {
        return inssatzKredit;
    }

    public void setInssatzKredit(int inssatzKredit) {
        this.inssatzKredit = inssatzKredit;
    }
    
}
