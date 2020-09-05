/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Tickettypes.findAll", query = "SELECT t FROM Tickettypes t")
    , @NamedQuery(name = "Tickettypes.findById", query = "SELECT t FROM Tickettypes t WHERE t.id = :id")
    , @NamedQuery(name = "Tickettypes.findByName", query = "SELECT t FROM Tickettypes t WHERE t.name = :name")
    , @NamedQuery(name = "Tickettypes.findByStatus", query = "SELECT t FROM Tickettypes t WHERE t.status = :status")})
public class Tickettypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applyTicketTypeID")
    private Collection<Vouchers> vouchersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketTypeID")
    private Collection<Seats> seatsCollection;

    public Tickettypes() {
    }

    public Tickettypes(Integer id) {
        this.id = id;
    }

    public Tickettypes(Integer id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Vouchers> getVouchersCollection() {
        return vouchersCollection;
    }

    public void setVouchersCollection(Collection<Vouchers> vouchersCollection) {
        this.vouchersCollection = vouchersCollection;
    }

    @XmlTransient
    public Collection<Seats> getSeatsCollection() {
        return seatsCollection;
    }

    public void setSeatsCollection(Collection<Seats> seatsCollection) {
        this.seatsCollection = seatsCollection;
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
        if (!(object instanceof Tickettypes)) {
            return false;
        }
        Tickettypes other = (Tickettypes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tickettypes[ id=" + id + " ]";
    }
    
}
