/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 53050
 */
@Entity
@Table(name = "CREDENTIALTABLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentialtable.findAll", query = "SELECT c FROM Credentialtable c")
    , @NamedQuery(name = "Credentialtable.findById", query = "SELECT c FROM Credentialtable c WHERE c.id = :id")
    , @NamedQuery(name = "Credentialtable.findByUserId", query = "SELECT c FROM Credentialtable c WHERE c.userid.id = :userid")
    , @NamedQuery(name = "Credentialtable.findByUsername", query = "SELECT c FROM Credentialtable c WHERE c.username = :username")
    , @NamedQuery(name = "Credentialtable.findByPasswdhash", query = "SELECT c FROM Credentialtable c WHERE c.passwdhash = :passwdhash")
    , @NamedQuery(name = "Credentialtable.findBySignupdate", query = "SELECT c FROM Credentialtable c WHERE c.signupdate = :signupdate")})
public class Credentialtable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 300)
    @Column(name = "PASSWDHASH")
    private String passwdhash;
    @Column(name = "SIGNUPDATE")
    @Temporal(TemporalType.DATE)
    private Date signupdate;
    @JoinColumn(name = "USERID", referencedColumnName = "ID")
    @ManyToOne
    private Usertable userid;

    public Credentialtable() {
    }

    public Credentialtable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswdhash() {
        return passwdhash;
    }

    public void setPasswdhash(String passwdhash) {
        this.passwdhash = passwdhash;
    }

    public Date getSignupdate() {
        return signupdate;
    }

    public void setSignupdate(Date signupdate) {
        this.signupdate = signupdate;
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
        if (!(object instanceof Credentialtable)) {
            return false;
        }
        Credentialtable other = (Credentialtable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assg1.Credentialtable[ id=" + id + " ]";
    }
    
    
    
}
