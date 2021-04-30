/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_mapp_c_uebung.model;

import javax.persistence.Embeddable;

/**
 *
 * @author jerem
 */
@Embeddable
public class Adresse {
    private String strasse;
    private int plz;

    public Adresse(String strasse, int plz) {
        this.strasse = strasse;
        this.plz = plz;
    }

    public Adresse() {
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }
    
    
}
