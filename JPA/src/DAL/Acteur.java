/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ikke
 */
@Entity
@Table(name = "tbl_acteurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acteur.findAll", query = "SELECT a FROM Acteur a"),
    @NamedQuery(name = "Acteur.findByActeurID", query = "SELECT a FROM Acteur a WHERE a.acteurID = :acteurID"),
    @NamedQuery(name = "Acteur.findByNaam", query = "SELECT a FROM Acteur a WHERE a.naam = :naam")})
public class Acteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acteur_ID")
    private Integer acteurID;
    @Basic(optional = false)
    @Column(name = "Naam")
    private String naam;

    public Acteur() {
    }

    public Acteur(Integer acteurID) {
        this.acteurID = acteurID;
    }

    public Acteur(Integer acteurID, String naam) {
        this.acteurID = acteurID;
        this.naam = naam;
    }
    //zelf toegevoegd
    public Acteur(String naam) {
        this.naam = naam;
    }
    
    public Integer getActeurID() {
        return acteurID;
    }

    public void setActeurID(Integer acteurID) {
        this.acteurID = acteurID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acteurID != null ? acteurID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acteur)) {
            return false;
        }
        Acteur other = (Acteur) object;
        if ((this.acteurID == null && other.acteurID != null) || (this.acteurID != null && !this.acteurID.equals(other.acteurID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "DAL.Acteur[ acteurID=" + acteurID + " ]";
        return naam;
    }
    
}
