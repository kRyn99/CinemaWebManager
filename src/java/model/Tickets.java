/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duckh
 */
@Entity
@Table(catalog = "cinemamanager", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t")
    , @NamedQuery(name = "Tickets.findById", query = "SELECT t FROM Tickets t WHERE t.id = :id")
    , @NamedQuery(name = "Tickets.findByCode", query = "SELECT t FROM Tickets t WHERE t.code = :code")
    , @NamedQuery(name = "Tickets.findByBookTime", query = "SELECT t FROM Tickets t WHERE t.bookTime = :bookTime")
    , @NamedQuery(name = "Tickets.findByCost", query = "SELECT t FROM Tickets t WHERE t.cost = :cost")
    , @NamedQuery(name = "Tickets.findByStatus", query = "SELECT t FROM Tickets t WHERE t.status = :status")})
public class Tickets implements Serializable {

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookTime;
    @Basic(optional = false)
    @Column(nullable = false)
    private float cost;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @JoinColumn(name = "ShowtimeDetailID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Showtimedetails showtimeDetailID;
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    @ManyToOne
    private Customers_1 customerID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Employees employeeID;
    @JoinColumn(name = "PromotionID", referencedColumnName = "ID")
    @ManyToOne
    private Promotions promotionID;
    @JoinColumn(name = "VoucherID", referencedColumnName = "ID")
    @ManyToOne
    private Vouchers voucherID;

    public Tickets() {
    }

    public Tickets(Integer id) {
        this.id = id;
    }

    public Tickets(Integer id, String code, Date bookTime, float cost, boolean status) {
        this.id = id;
        this.code = code;
        this.bookTime = bookTime;
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

    public Date getBookTime() {
        return bookTime;
    }

    public void setBookTime(Date bookTime) {
        this.bookTime = bookTime;
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

    public Showtimedetails getShowtimeDetailID() {
        return showtimeDetailID;
    }

    public void setShowtimeDetailID(Showtimedetails showtimeDetailID) {
        this.showtimeDetailID = showtimeDetailID;
    }

    public Customers_1 getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers_1 customerID) {
        this.customerID = customerID;
    }

    public Employees getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employees employeeID) {
        this.employeeID = employeeID;
    }

    public Promotions getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(Promotions promotionID) {
        this.promotionID = promotionID;
    }

    public Vouchers getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(Vouchers voucherID) {
        this.voucherID = voucherID;
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
        if (!(object instanceof Tickets)) {
            return false;
        }
        Tickets other = (Tickets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tickets[ id=" + id + " ]";
    }
    
}
