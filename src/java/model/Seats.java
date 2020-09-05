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
    @NamedQuery(name = "Seats.findAll", query = "SELECT s FROM Seats s")
    , @NamedQuery(name = "Seats.findById", query = "SELECT s FROM Seats s WHERE s.id = :id")
    , @NamedQuery(name = "Seats.findByRow", query = "SELECT s FROM Seats s WHERE s.row = :row")
    , @NamedQuery(name = "Seats.findBySeat", query = "SELECT s FROM Seats s WHERE s.seat = :seat")
    , @NamedQuery(name = "Seats.findByCost", query = "SELECT s FROM Seats s WHERE s.cost = :cost")
    , @NamedQuery(name = "Seats.findByStatus", query = "SELECT s FROM Seats s WHERE s.status = :status")})
public class Seats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String row;
    @Basic(optional = false)
    @Column(nullable = false)
    private int seat;
    @Basic(optional = false)
    @Column(nullable = false)
    private float cost;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean status;
    @JoinColumn(name = "RoomID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Rooms roomID;
    @JoinColumn(name = "TicketTypeID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private Tickettypes ticketTypeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seatID")
    private Collection<Showtimedetails> showtimedetailsCollection;

    public Seats() {
    }

    public Seats(Integer id) {
        this.id = id;
    }

    public Seats(Integer id, String row, int seat, float cost, boolean status) {
        this.id = id;
        this.row = row;
        this.seat = seat;
        this.cost = cost;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
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

    public Rooms getRoomID() {
        return roomID;
    }

    public void setRoomID(Rooms roomID) {
        this.roomID = roomID;
    }

    public Tickettypes getTicketTypeID() {
        return ticketTypeID;
    }

    public void setTicketTypeID(Tickettypes ticketTypeID) {
        this.ticketTypeID = ticketTypeID;
    }

    @XmlTransient
    public Collection<Showtimedetails> getShowtimedetailsCollection() {
        return showtimedetailsCollection;
    }

    public void setShowtimedetailsCollection(Collection<Showtimedetails> showtimedetailsCollection) {
        this.showtimedetailsCollection = showtimedetailsCollection;
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
        if (!(object instanceof Seats)) {
            return false;
        }
        Seats other = (Seats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seats[ id=" + id + " ]";
    }
    
}
