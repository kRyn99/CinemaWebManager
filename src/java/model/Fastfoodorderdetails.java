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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duckh
 */
@Entity
@Table(catalog = "cinemamanager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fastfoodorderdetails.findAll", query = "SELECT f FROM Fastfoodorderdetails f")
    , @NamedQuery(name = "Fastfoodorderdetails.findById", query = "SELECT f FROM Fastfoodorderdetails f WHERE f.id = :id")
    , @NamedQuery(name = "Fastfoodorderdetails.findByQuantity", query = "SELECT f FROM Fastfoodorderdetails f WHERE f.quantity = :quantity")})
public class Fastfoodorderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantity;
    @JoinColumn(name = "FastFoodID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Fastfoods fastFoodID;
    @JoinColumn(name = "FastFoodOrderID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Fastfoodorders fastFoodOrderID;

    public Fastfoodorderdetails() {
    }

    public Fastfoodorderdetails(Integer id) {
        this.id = id;
    }

    public Fastfoodorderdetails(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Fastfoods getFastFoodID() {
        return fastFoodID;
    }

    public void setFastFoodID(Fastfoods fastFoodID) {
        this.fastFoodID = fastFoodID;
    }

    public Fastfoodorders getFastFoodOrderID() {
        return fastFoodOrderID;
    }

    public void setFastFoodOrderID(Fastfoodorders fastFoodOrderID) {
        this.fastFoodOrderID = fastFoodOrderID;
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
        if (!(object instanceof Fastfoodorderdetails)) {
            return false;
        }
        Fastfoodorderdetails other = (Fastfoodorderdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fastfoodorderdetails[ id=" + id + " ]";
    }
    
}
