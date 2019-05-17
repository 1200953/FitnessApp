/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 53050
 */
@Entity
@Table(name = "USERTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertable.findAll", query = "SELECT u FROM Usertable u")
    , @NamedQuery(name = "Usertable.findById", query = "SELECT u FROM Usertable u WHERE u.id = :id")           
    , @NamedQuery(name = "Usertable.findByName", query = "SELECT u FROM Usertable u WHERE u.name = :name")
    , @NamedQuery(name = "Usertable.findBySurnname", query = "SELECT u FROM Usertable u WHERE u.surnname = :surnname")
    , @NamedQuery(name = "Usertable.findByEmail", query = "SELECT u FROM Usertable u WHERE u.email = :email")
    , @NamedQuery(name = "Usertable.findByDob", query = "SELECT u FROM Usertable u WHERE u.dob = :dob")
    , @NamedQuery(name = "Usertable.findByHeight", query = "SELECT u FROM Usertable u WHERE u.height = :height")
    , @NamedQuery(name = "Usertable.findByWeight", query = "SELECT u FROM Usertable u WHERE u.weight = :weight")
    , @NamedQuery(name = "Usertable.findByGender", query = "SELECT u FROM Usertable u WHERE u.gender = :gender")
    , @NamedQuery(name = "Usertable.findByAddress", query = "SELECT u FROM Usertable u WHERE u.address = :address")
    , @NamedQuery(name = "Usertable.findByPostcode", query = "SELECT u FROM Usertable u WHERE u.postcode = :postcode")
    , @NamedQuery(name = "Usertable.findByLeveloffactivity", query = "SELECT u FROM Usertable u WHERE u.leveloffactivity = :leveloffactivity")
    , @NamedQuery(name = "Usertable.findByStepspermile", query = "SELECT u FROM Usertable u WHERE u.stepspermile = :stepspermile")})
public class Usertable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "SURNNAME")
    private String surnname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Size(max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 80)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 4)
    @Column(name = "POSTCODE")
    private String postcode;
    @Column(name = "LEVELOFFACTIVITY")
    private Integer leveloffactivity;
    @Column(name = "STEPSPERMILE")
    private Integer stepspermile;
    @OneToMany(mappedBy = "userid",cascade = CascadeType.PERSIST)
    private Collection<Consumptiontable> consumptiontableCollection;
    @OneToMany(mappedBy = "userid",cascade = CascadeType.PERSIST)
    private Collection<Reporttable> reporttableCollection;
    @OneToMany(mappedBy = "userid",cascade = CascadeType.PERSIST)
    private Collection<Credentialtable> credentialtableCollection;

    public Usertable() {
    }

    public Usertable(Integer id) {
        this.id = id;
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

    public String getSurnname() {
        return surnname;
    }

    public void setSurnname(String surnname) {
        this.surnname = surnname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getLeveloffactivity() {
        return leveloffactivity;
    }

    public void setLeveloffactivity(Integer leveloffactivity) {
        this.leveloffactivity = leveloffactivity;
    }

    public Integer getStepspermile() {
        return stepspermile;
    }

    public void setStepspermile(Integer stepspermile) {
        this.stepspermile = stepspermile;
    }

    @XmlTransient
    public Collection<Consumptiontable> getConsumptiontableCollection() {
        return consumptiontableCollection;
    }

    public void setConsumptiontableCollection(Collection<Consumptiontable> consumptiontableCollection) {
        this.consumptiontableCollection = consumptiontableCollection;
    }

    @XmlTransient
    public Collection<Reporttable> getReporttableCollection() {
        return reporttableCollection;
    }

    public void setReporttableCollection(Collection<Reporttable> reporttableCollection) {
        this.reporttableCollection = reporttableCollection;
    }

    @XmlTransient
    public Collection<Credentialtable> getCredentialtableCollection() {
        return credentialtableCollection;
    }

    public void setCredentialtableCollection(Collection<Credentialtable> credentialtableCollection) {
        this.credentialtableCollection = credentialtableCollection;
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
        if (!(object instanceof Usertable)) {
            return false;
        }
        Usertable other = (Usertable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assg1.Usertable[ id=" + id + " ]";
    }
    
}
