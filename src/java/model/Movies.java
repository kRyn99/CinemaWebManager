/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duckh
 */
@Entity
@Table(catalog = "cinemamanager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m")
    , @NamedQuery(name = "Movies.findById", query = "SELECT m FROM Movies m WHERE m.id = :id")
    , @NamedQuery(name = "Movies.findByCode", query = "SELECT m FROM Movies m WHERE m.code = :code")
    , @NamedQuery(name = "Movies.findByName", query = "SELECT m FROM Movies m WHERE m.name = :name")
    , @NamedQuery(name = "Movies.findByRated", query = "SELECT m FROM Movies m WHERE m.rated = :rated")
    , @NamedQuery(name = "Movies.findByLength", query = "SELECT m FROM Movies m WHERE m.length = :length")
    , @NamedQuery(name = "Movies.findByOpeningDay", query = "SELECT m FROM Movies m WHERE m.openingDay = :openingDay")
    , @NamedQuery(name = "Movies.findByStatus", query = "SELECT m FROM Movies m WHERE m.status = :status")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private short rated;
    @Basic(optional = false)
    @Column(nullable = false)
    private int length;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date openingDay;
    @Lob
    @Column(length = 65535)
    private String description;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 16777215)
    private String posterURL;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieID")
    private Collection<Genredetails> genredetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieID")
    private Collection<Showtimes> showtimesCollection;

    public Movies() {
    }

    public Movies(Integer id) {
        this.id = id;
    }

    public Movies(Integer id, String code, String name, short rated, int length, Date openingDay, String posterURL, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.rated = rated;
        this.length = length;
        this.openingDay = openingDay;
        this.posterURL = posterURL;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getRated() {
        return rated;
    }

    public void setRated(short rated) {
        this.rated = rated;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getOpeningDay() {
        return openingDay;
    }

    public void setOpeningDay(Date openingDay) {
        this.openingDay = openingDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Genredetails> getGenredetailsCollection() {
        return genredetailsCollection;
    }

    public void setGenredetailsCollection(Collection<Genredetails> genredetailsCollection) {
        this.genredetailsCollection = genredetailsCollection;
    }

    @XmlTransient
    public Collection<Showtimes> getShowtimesCollection() {
        return showtimesCollection;
    }

    public void setShowtimesCollection(Collection<Showtimes> showtimesCollection) {
        this.showtimesCollection = showtimesCollection;
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
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Movies[ id=" + id + " ]";
    }
    
}
