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
    @NamedQuery(name = "Fastfoods.findAll", query = "SELECT f FROM Fastfoods f")
    , @NamedQuery(name = "Fastfoods.findById", query = "SELECT f FROM Fastfoods f WHERE f.id = :id")
    , @NamedQuery(name = "Fastfoods.findByCode", query = "SELECT f FROM Fastfoods f WHERE f.code = :code")
    , @NamedQuery(name = "Fastfoods.findByName", query = "SELECT f FROM Fastfoods f WHERE f.name = :name")
    , @NamedQuery(name = "Fastfoods.findByType", query = "SELECT f FROM Fastfoods f WHERE f.type = :type")
    , @NamedQuery(name = "Fastfoods.findBySize", query = "SELECT f FROM Fastfoods f WHERE f.size = :size")
    , @NamedQuery(name = "Fastfoods.findByQuantity", query = "SELECT f FROM Fastfoods f WHERE f.quantity = :quantity")
    , @NamedQuery(name = "Fastfoods.findByCost", query = "SELECT f FROM Fastfoods f WHERE f.cost = :cost")
    , @NamedQuery(name = "Fastfoods.findByStatus", query = "SELECT f FROM Fastfoods f WHERE f.status = :status")})
public class Fastfoods implements Serializable {

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
    @Column(nullable = false, length = 20)
    private String type;
    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String size;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantity;
    @Basic(optional = false)
    @Column(nullable = false)
    private float cost;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applyFastFoodID")
    private Collection<Vouchers> vouchersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fastFoodID")
    private Collection<Combos> combosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fastFoodID")
    private Collection<Fastfoodorderdetails> fastfoodorderdetailsCollection;

    public Fastfoods() {
    }

    public Fastfoods(Integer id) {
        this.id = id;
    }

    public Fastfoods(Integer id, String code, String name, String type, String size, int quantity, float cost, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.cost = cost;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @XmlTransient
    public Collection<Combos> getCombosCollection() {
        return combosCollection;
    }

    public void setCombosCollection(Collection<Combos> combosCollection) {
        this.combosCollection = combosCollection;
    }

    @XmlTransient
    public Collection<Fastfoodorderdetails> getFastfoodorderdetailsCollection() {
        return fastfoodorderdetailsCollection;
    }

    public void setFastfoodorderdetailsCollection(Collection<Fastfoodorderdetails> fastfoodorderdetailsCollection) {
        this.fastfoodorderdetailsCollection = fastfoodorderdetailsCollection;
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
        if (!(object instanceof Fastfoods)) {
            return false;
        }
        Fastfoods other = (Fastfoods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fastfoods[ id=" + id + " ]";
    }
    
}
