/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jerem
 */
@Entity
@Table(name = "TEST_A_JPQL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestAJpql.findAll", query = "SELECT t FROM TestAJpql t")
    , @NamedQuery(name = "TestAJpql.findById", query = "SELECT t FROM TestAJpql t WHERE t.id = :id")
    , @NamedQuery(name = "TestAJpql.findByVorname", query = "SELECT t FROM TestAJpql t WHERE t.vorname = :vorname")
    , @NamedQuery(name = "TestAJpql.findByNachname", query = "SELECT t FROM TestAJpql t WHERE t.nachname = :nachname")})
public class TestAJpql implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "VORNAME")
    private String vorname;
    @Column(name = "NACHNAME")
    private String nachname;

    public TestAJpql() {
    }

    public TestAJpql(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
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
        if (!(object instanceof TestAJpql)) {
            return false;
        }
        TestAJpql other = (TestAJpql) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TestAJpql[ id=" + id + " ]";
    }
    
}
