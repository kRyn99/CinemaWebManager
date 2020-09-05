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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Combos.findAll", query = "SELECT c FROM Combos c")
    , @NamedQuery(name = "Combos.findById", query = "SELECT c FROM Combos c WHERE c.id = :id")
    , @NamedQuery(name = "Combos.findByName", query = "SELECT c FROM Combos c WHERE c.name = :name")
    , @NamedQuery(name = "Combos.findByTotalTicket", query = "SELECT c FROM Combos c WHERE c.totalTicket = :totalTicket")
    , @NamedQuery(name = "Combos.findBySeatType", query = "SELECT c FROM Combos c WHERE c.seatType = :seatType")
    , @NamedQuery(name = "Combos.findByCost", query = "SELECT c FROM Combos c WHERE c.cost = :cost")
    , @NamedQuery(name = "Combos.findByStatus", query = "SELECT c FROM Combos c WHERE c.status = :status")})
public class Combos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private short totalTicket;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String seatType;
    @Basic(optional = false)
    @Column(nullable = false)
    private float cost;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applyComboID")
    private Collection<Vouchers> vouchersCollection;
    @JoinColumn(name = "FastFoodID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Fastfoods fastFoodID;

    public Combos() {
    }

    public Combos(Integer id) {
        this.id = id;
    }

    public Combos(Integer id, String name, short totalTicket, String seatType, float cost, boolean status) {
        this.id = id;
        this.name = name;
        this.totalTicket = totalTicket;
        this.seatType = seatType;
        this.cost = cost;
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

    public short getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(short totalTicket) {
        this.totalTicket = totalTicket;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
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

    public Fastfoods getFastFoodID() {
        return fastFoodID;
    }

    public void setFastFoodID(Fastfoods fastFoodID) {
        this.fastFoodID = fastFoodID;
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
        if (!(object instanceof Combos)) {
            return false;
        }
        Combos other = (Combos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Combos[ id=" + id + " ]";
    }
    
}
