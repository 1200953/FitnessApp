/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 53050
 */
@Entity
@Table(name = "REPORTTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reporttable.findAll", query = "SELECT r FROM Reporttable r")
    , @NamedQuery(name = "Reporttable.findById", query = "SELECT r FROM Reporttable r WHERE r.id = :id")
    , @NamedQuery(name = "Reporttable.findByRdate", query = "SELECT r FROM Reporttable r WHERE r.rdate = :rdate")
    , @NamedQuery(name = "Reporttable.findByCalconsumed", query = "SELECT r FROM Reporttable r WHERE r.calconsumed = :calconsumed")
    , @NamedQuery(name = "Reporttable.findByCalburned", query = "SELECT r FROM Reporttable r WHERE r.calburned = :calburned")
    , @NamedQuery(name = "Reporttable.findByStepstaken", query = "SELECT r FROM Reporttable r WHERE r.stepstaken = :stepstaken")
    , @NamedQuery(name = "Reporttable.findByCalgoal", query = "SELECT r FROM Reporttable r WHERE r.calgoal = :calgoal")})
public class Reporttable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "RDATE")
    @Temporal(TemporalType.DATE)
    private Date rdate;
    @Column(name = "CALCONSUMED")
    private Integer calconsumed;
    @Column(name = "CALBURNED")
    private Integer calburned;
    @Column(name = "STEPSTAKEN")
    private Integer stepstaken;
    @Column(name = "CALGOAL")
    private Integer calgoal;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Usertable userid;

    public Reporttable() {
    }

    public Reporttable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public Integer getCalconsumed() {
        return calconsumed;
    }

    public void setCalconsumed(Integer calconsumed) {
        this.calconsumed = calconsumed;
    }

    public Integer getCalburned() {
        return calburned;
    }

    public void setCalburned(Integer calburned) {
        this.calburned = calburned;
    }

    public Integer getStepstaken() {
        return stepstaken;
    }

    public void setStepstaken(Integer stepstaken) {
        this.stepstaken = stepstaken;
    }

    public Integer getCalgoal() {
        return calgoal;
    }

    public void setCalgoal(Integer calgoal) {
        this.calgoal = calgoal;
    }

    public Usertable getUserid() {
        return userid;
    }

    public void setUserid(Usertable userid) {
        this.userid = userid;
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
        if (!(object instanceof Reporttable)) {
            return false;
        }
        Reporttable other = (Reporttable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assg1.Reporttable[ id=" + id + " ]";
    }
    
}
