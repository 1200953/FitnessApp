/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1.service;

import assg1.Credentialtable;
import assg1.Foodtable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 53050
 */
@Stateless
@Path("assg1.credentialtable")
public class CredentialtableFacadeREST extends AbstractFacade<Credentialtable> {

    @PersistenceContext(unitName = "fitappPU")
    private EntityManager em;

    public CredentialtableFacadeREST() {
        super(Credentialtable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Credentialtable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Credentialtable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Credentialtable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("findByUserId/{userid}")
    @Produces({"application/json"})
    public List<Credentialtable> findByUserId(@PathParam("userid") String userid) {
        Query query = em.createNamedQuery("Credentialtable.findByUserId");
        query.setParameter("userid", userid);
        return query.getResultList();
    }
    
    @GET
    @Path("findByUsername/{username}")
    @Produces({"application/json"})
    public List<Credentialtable> findByUsername(@PathParam("username") String username) {
        Query query = em.createNamedQuery("Credentialtable.findByUsername");
        query.setParameter("username", username);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPasswdhash/{passwdhash}")
    @Produces({"application/json"})
    public List<Credentialtable> findByPasswdhash(@PathParam("passwdhash") String passwdhash) {
        Query query = em.createNamedQuery("Credentialtable.findByPasswdhash");
        query.setParameter("passwdhash", passwdhash);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySignupdate/{signupdate}")
    @Produces({"application/json"})
    public List<Credentialtable> findByEmail(@PathParam("signupdate") String signupdatestr) throws ParseException {
        Date signupdate=new SimpleDateFormat("yyyy-MM-dd").parse(signupdatestr);
        Query query = em.createNamedQuery("Credentialtable.findBySignupdate");
        query.setParameter("signupdate", signupdate);
        return query.getResultList();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialtable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Credentialtable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("verifyUser/{username}/{passwdhash}")
    @Produces({"application/json"})
    public List<Credentialtable> verifyCre(@PathParam("username") String
        username,@PathParam("passwdhash") String passwdhash) {
            TypedQuery<Credentialtable> q = em.createQuery("SELECT s FROM Credentialtable s WHERE s.username = :username AND s.passwdhash = :passwdhash", Credentialtable.class);
            q.setParameter("username", username);
            q.setParameter("passwdhash", passwdhash);
            return q.getResultList();
    }
    
}
