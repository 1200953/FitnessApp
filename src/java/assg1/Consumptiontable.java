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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 53050
 */
@Entity
@Table(name = "CONSUMPTIONTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consumptiontable.findAll", query = "SELECT c FROM Consumptiontable c")
    , @NamedQuery(name = "Consumptiontable.findById", query = "SELECT c FROM Consumptiontable c WHERE c.id = :id")
    , @NamedQuery(name = "Consumptiontable.findByFoodid", query = "SELECT c FROM Consumptiontable c WHERE c.foodid.id = :foodid")
    , @NamedQuery(name = "Consumptiontable.findByUserid", query = "SELECT c FROM Consumptiontable c WHERE c.userid.id = :userid")
    , @NamedQuery(name = "Consumptiontable.findByFidAName", query = "SELECT c FROM Consumptiontable c WHERE c.foodid.id = :foodid AND c.foodid.foodname = :foodname")
    , @NamedQuery(name = "Consumptiontable.findByCdate", query = "SELECT c FROM Consumptiontable c WHERE c.cdate = :cdate")
    , @NamedQuery(name = "Consumptiontable.findByServingunit", query = "SELECT c FROM Consumptiontable c WHERE c.servingunit = :servingunit")
    , @NamedQuery(name = "Consumptiontable.findByServingamount", query = "SELECT c FROM Consumptiontable c WHERE c.servingamount = :servingamount")})
public class Consumptiontable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CDATE")
    @Temporal(TemporalType.DATE)
    private Date cdate;
    @Size(max = 20)
    @Column(name = "SERVINGUNIT")
    private String servingunit;
    @Column(name = "SERVINGAMOUNT")
    private Integer servingamount;
    @JoinColumn(name = "FOODID", referencedColumnName = "ID")
    @ManyToOne
    private Foodtable foodid;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Usertable userid;

    public Consumptiontable() {
    }

    public Consumptiontable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getServingunit() {
        return servingunit;
    }

    public void setServingunit(String servingunit) {
        this.servingunit = servingunit;
    }

    public Integer getServingamount() {
        return servingamount;
    }

    public void setServingamount(Integer servingamount) {
        this.servingamount = servingamount;
    }

    public Foodtable getFoodid() {
        return foodid;
    }

    public void setFoodid(Foodtable foodid) {
        this.foodid = foodid;
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
        if (!(object instanceof Consumptiontable)) {
            return false;
        }
        Consumptiontable other = (Consumptiontable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assg1.Consumptiontable[ id=" + id + " ]";
    }
    
}
