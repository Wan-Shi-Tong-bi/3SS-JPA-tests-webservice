/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a_mapp_c_uebung.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jerem
 */
@Entity
public class Termin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    private Person besitzer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Teilnehmer",
            joinColumns = {@JoinColumn(name="Termin_id")},
            inverseJoinColumns = {@JoinColumn(name="Person_id")})
    private List<Person> teilnehmer;

    public Termin() {
    }

    public Termin(String name, Person besitzer) {
        this.name = name;
        this.besitzer = besitzer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Person getBesitzer() {
        return besitzer;
    }

    public void setBesitzer(Person besitzer) {
        this.besitzer = besitzer;
    }

    public List<Person> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(List<Person> teilnehmer) {
        this.teilnehmer = teilnehmer;
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
        if (!(object instanceof Termin)) {
            return false;
        }
        Termin other = (Termin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "a_mapp_c_uebung.model.Termin[ id=" + id + " ]";
    }
    
}
