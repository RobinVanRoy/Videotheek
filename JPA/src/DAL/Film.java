/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.Comparator;
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
@Table(name = "tbl_films")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findByFilmID", query = "SELECT f FROM Film f WHERE f.filmID = :filmID"),
    @NamedQuery(name = "Film.findByTitel", query = "SELECT f FROM Film f WHERE f.titel = :titel"),
    @NamedQuery(name = "Film.findByGenre", query = "SELECT f FROM Film f WHERE f.genre = :genre"),
    @NamedQuery(name = "Film.findByOmschrijving", query = "SELECT f FROM Film f WHERE f.omschrijving = :omschrijving"),
    @NamedQuery(name = "Film.findByJaar", query = "SELECT f FROM Film f WHERE f.jaar = :jaar"),
    @NamedQuery(name = "Film.findByActeurs", query = "SELECT f FROM Film f WHERE f.acteurs = :acteurs"),
    @NamedQuery(name = "Film.findByUitgeleend", query = "SELECT f FROM Film f WHERE f.uitgeleend = :uitgeleend")})
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "film_ID")
    private Integer filmID;
    @Basic(optional = false)
    @Column(name = "Titel")
    private String titel;
    @Basic(optional = false)
    @Column(name = "Genre")
    private String genre;
    @Basic(optional = false)
    @Column(name = "Omschrijving")
    private String omschrijving;
    @Basic(optional = false)
    @Column(name = "Jaar")
    private int jaar;
    @Basic(optional = false)
    @Column(name = "Acteurs")
    private String acteurs;
    @Basic(optional = false)
    @Column(name = "Uitgeleend")
    private boolean uitgeleend;

    public Film() {
    }

    public Film(Integer filmID) {
        this.filmID = filmID;
    }

    public Film(Integer filmID, String titel, String genre, String omschrijving, int jaar, String acteurs, boolean uitgeleend) {
        this.filmID = filmID;
        this.titel = titel;
        this.genre = genre;
        this.omschrijving = omschrijving;
        this.jaar = jaar;
        this.acteurs = acteurs;
        this.uitgeleend = uitgeleend;
    }
    //zelf toegevoegd
    public Film(String titel, String genre, String omschrijving, int jaar, String acteurs, boolean uitgeleend) {
        this.titel = titel;
        this.genre = genre;
        this.omschrijving = omschrijving;
        this.jaar = jaar;
        this.acteurs = acteurs;
        this.uitgeleend = uitgeleend;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        this.jaar = jaar;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    public boolean getUitgeleend() {
        return uitgeleend;
    }

    public void setUitgeleend(boolean uitgeleend) {
        this.uitgeleend = uitgeleend;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmID != null ? filmID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmID == null && other.filmID != null) || (this.filmID != null && !this.filmID.equals(other.filmID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "DAL.Film[ filmID=" + filmID + " ]";
        return titel;
    }
    
}
