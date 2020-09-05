/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
    @NamedQuery(name = "Vouchers.findAll", query = "SELECT v FROM Vouchers v")
    , @NamedQuery(name = "Vouchers.findById", query = "SELECT v FROM Vouchers v WHERE v.id = :id")
    , @NamedQuery(name = "Vouchers.findByCode", query = "SELECT v FROM Vouchers v WHERE v.code = :code")
    , @NamedQuery(name = "Vouchers.findByDiscount", query = "SELECT v FROM Vouchers v WHERE v.discount = :discount")
    , @NamedQuery(name = "Vouchers.findByType", query = "SELECT v FROM Vouchers v WHERE v.type = :type")
    , @NamedQuery(name = "Vouchers.findByApplyFor", query = "SELECT v FROM Vouchers v WHERE v.applyFor = :applyFor")
    , @NamedQuery(name = "Vouchers.findByStatus", query = "SELECT v FROM Vouchers v WHERE v.status = :status")})
public class Vouchers implements Serializable {

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
    @Column(nullable = false)
    private float discount;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String type;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String applyFor;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(mappedBy = "voucherID")
    private Collection<Tickets> ticketsCollection;
    @JoinColumn(name = "ApplyFastFoodID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Fastfoods applyFastFoodID;
    @JoinColumn(name = "ApplyTicketTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Tickettypes applyTicketTypeID;
    @JoinColumn(name = "ApplyComboID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Combos applyComboID;
    @OneToMany(mappedBy = "voucherID")
    private Collection<Fastfoodorders> fastfoodordersCollection;

    public Vouchers() {
    }

    public Vouchers(Integer id) {
        this.id = id;
    }

    public Vouchers(Integer id, String code, float discount, String type, String applyFor, boolean status) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.type = type;
        this.applyFor = applyFor;
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

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    public Fastfoods getApplyFastFoodID() {
        return applyFastFoodID;
    }

    public void setApplyFastFoodID(Fastfoods applyFastFoodID) {
        this.applyFastFoodID = applyFastFoodID;
    }

    public Tickettypes getApplyTicketTypeID() {
        return applyTicketTypeID;
    }

    public void setApplyTicketTypeID(Tickettypes applyTicketTypeID) {
        this.applyTicketTypeID = applyTicketTypeID;
    }

    public Combos getApplyComboID() {
        return applyComboID;
    }

    public void setApplyComboID(Combos applyComboID) {
        this.applyComboID = applyComboID;
    }

    @XmlTransient
    public Collection<Fastfoodorders> getFastfoodordersCollection() {
        return fastfoodordersCollection;
    }

    public void setFastfoodordersCollection(Collection<Fastfoodorders> fastfoodordersCollection) {
        this.fastfoodordersCollection = fastfoodordersCollection;
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
        if (!(object instanceof Vouchers)) {
            return false;
        }
        Vouchers other = (Vouchers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vouchers[ id=" + id + " ]";
    }
    
}
