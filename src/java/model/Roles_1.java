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
@Table(name = "roles", catalog = "cinemamanager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles_1.findAll", query = "SELECT r FROM Roles_1 r")
    , @NamedQuery(name = "Roles_1.findById", query = "SELECT r FROM Roles_1 r WHERE r.id = :id")
    , @NamedQuery(name = "Roles_1.findByName", query = "SELECT r FROM Roles_1 r WHERE r.name = :name")
    , @NamedQuery(name = "Roles_1.findByStatus", query = "SELECT r FROM Roles_1 r WHERE r.status = :status")})
public class Roles_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 25)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<Customers_1> customersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleID")
    private Collection<Employees> employeesCollection;

    public Roles_1() {
    }

    public Roles_1(Integer id) {
        this.id = id;
    }

    public Roles_1(Integer id, String name, boolean status) {
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
    public Collection<Customers_1> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customers_1> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
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
        if (!(object instanceof Roles_1)) {
            return false;
        }
        Roles_1 other = (Roles_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Roles_1[ id=" + id + " ]";
    }
    
}
