/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author jerem
 */
@Entity
public class Kunde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nachname;
    private String vorname;
    //wichtig bei Datum für eintragen in die Tabelle - Date verwenden
//    @Temporal(javax.persistence.TemporalType.DATE)
    private LocalDate geburtsdatum;
    @OneToMany(mappedBy="istKonto")
    @JoinTable(name="Kund_Konto", joinColumns = 
            @JoinColumn(name="kunde_id"),inverseJoinColumns = 
            @JoinColumn(name="konto_id"))
    private List<Konto> kontos = new LinkedList<Konto>();

    public Kunde(String nachname, String vorname, LocalDate geburtsdatum) {
        this.nachname = nachname;
        this.vorname = vorname;
        this.geburtsdatum = geburtsdatum;
    }

    public Kunde() {
    }

    public List<Konto> getKontos() {
        return kontos;
    }

    public void setKontos(List<Konto> kontos) {
        this.kontos = kontos;
    }

    
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Kunde[ id=" + id + " ]";
    }
    
}
