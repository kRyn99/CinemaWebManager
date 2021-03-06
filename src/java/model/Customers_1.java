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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duckh
 */
@Entity
@Table(name = "customers", catalog = "cinemamanager", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Username"})
    , @UniqueConstraint(columnNames = {"PhoneNumber"})
    , @UniqueConstraint(columnNames = {"CitizenID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers_1.findAll", query = "SELECT c FROM Customers_1 c")
    , @NamedQuery(name = "Customers_1.findById", query = "SELECT c FROM Customers_1 c WHERE c.id = :id")
    , @NamedQuery(name = "Customers_1.findByCode", query = "SELECT c FROM Customers_1 c WHERE c.code = :code")
    , @NamedQuery(name = "Customers_1.findByName", query = "SELECT c FROM Customers_1 c WHERE c.name = :name")
    , @NamedQuery(name = "Customers_1.findByBirthDate", query = "SELECT c FROM Customers_1 c WHERE c.birthDate = :birthDate")
    , @NamedQuery(name = "Customers_1.findByPhoneNumber", query = "SELECT c FROM Customers_1 c WHERE c.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "Customers_1.findByCitizenID", query = "SELECT c FROM Customers_1 c WHERE c.citizenID = :citizenID")
    , @NamedQuery(name = "Customers_1.findByMemberType", query = "SELECT c FROM Customers_1 c WHERE c.memberType = :memberType")
    , @NamedQuery(name = "Customers_1.findByPoint", query = "SELECT c FROM Customers_1 c WHERE c.point = :point")
    , @NamedQuery(name = "Customers_1.findByRegisterDate", query = "SELECT c FROM Customers_1 c WHERE c.registerDate = :registerDate")
    , @NamedQuery(name = "Customers_1.findByUsername", query = "SELECT c FROM Customers_1 c WHERE c.username = :username")
    , @NamedQuery(name = "Customers_1.findByStatus", query = "SELECT c FROM Customers_1 c WHERE c.status = :status")})
public class Customers_1 implements Serializable {

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
    @Column(nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String phoneNumber;
    @Basic(optional = false)
    @Column(nullable = false, length = 12)
    private String citizenID;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String memberType;
    @Basic(optional = false)
    @Column(nullable = false)
    private int point;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerDate;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 16777215)
    private String password;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @OneToMany(mappedBy = "customerID")
    private Collection<Tickets> ticketsCollection;
    @OneToMany(mappedBy = "customerID")
    private Collection<Fastfoodorders> fastfoodordersCollection;
    @JoinColumn(name = "RoleID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Roles_1 roleID;

    public Customers_1() {
    }

    public Customers_1(Integer id) {
        this.id = id;
    }

    public Customers_1(Integer id, String code, String name, Date birthDate, String phoneNumber, String citizenID, String memberType, int point, Date registerDate, String username, String password, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.citizenID = citizenID;
        this.memberType = memberType;
        this.point = point;
        this.registerDate = registerDate;
        this.username = username;
        this.password = password;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public Collection<Fastfoodorders> getFastfoodordersCollection() {
        return fastfoodordersCollection;
    }

    public void setFastfoodordersCollection(Collection<Fastfoodorders> fastfoodordersCollection) {
        this.fastfoodordersCollection = fastfoodordersCollection;
    }

    public Roles_1 getRoleID() {
        return roleID;
    }

    public void setRoleID(Roles_1 roleID) {
        this.roleID = roleID;
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
        if (!(object instanceof Customers_1)) {
            return false;
        }
        Customers_1 other = (Customers_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Customers_1[ id=" + id + " ]";
    }
    
}
