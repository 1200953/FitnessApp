/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 53050
 */
@Entity
@Table(name = "FOODTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Foodtable.findAll", query = "SELECT f FROM Foodtable f")
    , @NamedQuery(name = "Foodtable.findById", query = "SELECT f FROM Foodtable f WHERE f.id = :id")
    , @NamedQuery(name = "Foodtable.findByFoodname", query = "SELECT f FROM Foodtable f WHERE f.foodname = :foodname")
    , @NamedQuery(name = "Foodtable.findByCategory", query = "SELECT f FROM Foodtable f WHERE f.category = :category")
    , @NamedQuery(name = "Foodtable.findByCalamount", query = "SELECT f FROM Foodtable f WHERE f.calamount = :calamount")
    , @NamedQuery(name = "Foodtable.findByServingunit", query = "SELECT f FROM Foodtable f WHERE f.servingunit = :servingunit")
    , @NamedQuery(name = "Foodtable.findByServingamount", query = "SELECT f FROM Foodtable f WHERE f.servingamount = :servingamount")
    , @NamedQuery(name = "Foodtable.findByFat", query = "SELECT f FROM Foodtable f WHERE f.fat = :fat")})
public class Foodtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "FOODNAME")
    private String foodname;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "CALAMOUNT")
    private Integer calamount;
    @Size(max = 20)
    @Column(name = "SERVINGUNIT")
    private String servingunit;
    @Column(name = "SERVINGAMOUNT")
    private Integer servingamount;
    @Column(name = "FAT")
    private Integer fat;
    @OneToMany(mappedBy = "foodid")
    private Collection<Consumptiontable> consumptiontableCollection;

    public Foodtable() {
    }

    public Foodtable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCalamount() {
        return calamount;
    }

    public void setCalamount(Integer calamount) {
        this.calamount = calamount;
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

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    @XmlTransient
    public Collection<Consumptiontable> getConsumptiontableCollection() {
        return consumptiontableCollection;
    }

    public void setConsumptiontableCollection(Collection<Consumptiontable> consumptiontableCollection) {
        this.consumptiontableCollection = consumptiontableCollection;
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
        if (!(object instanceof Foodtable)) {
            return false;
        }
        Foodtable other = (Foodtable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assg1.Foodtable[ id=" + id + " ]";
    }
    
}
