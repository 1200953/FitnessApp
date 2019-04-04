/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1.service;

import assg1.Usertable;
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
@Path("assg1.usertable")
public class UsertableFacadeREST extends AbstractFacade<Usertable> {

    @PersistenceContext(unitName = "fitappPU")
    private EntityManager em;

    public UsertableFacadeREST() {
        super(Usertable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Usertable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Usertable entity) {
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
    public Usertable find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    

    
    @GET
    @Path("findByPost/{postcode}")
    @Produces({"application/json"})
    public List<Usertable> findByPost(@PathParam("{postcode}") String 
            postcode) {
            TypedQuery<Usertable> q = em.createQuery("SELECT u FROM Usertable u WHERE u.postcode = :postcode", Usertable.class);
            q.setParameter("postcode", postcode);
            return q.getResultList();
    }
    
    @GET
    @Path("findByFullName/{name}/{surnname}")
    @Produces({"application/json"})
    public List<Usertable> findByFullName(@PathParam("{name}") String name,@PathParam("{surnname}") String surnname) {
    TypedQuery<Usertable> q = em.createQuery("SELECT s.name, s.surnname FROM Usertable s WHERE s.name = :name AND s.surnname = :surnname", 
            Usertable.class);
    q.setParameter("name", name);
    q.setParameter("surnname", surnname);
    return q.getResultList();
    }
//Note: 
    
    @GET
    @Path("findByName/{name}")
    @Produces({"application/json"})
    public List<Usertable> findByName(@PathParam("name") String name) {
        Query query = em.createNamedQuery("Usertable.findByName");
        query.setParameter("name", name);
        return query.getResultList();
    }
    
    @GET
    @Path("findBySurnname/{surnname}")
    @Produces({"application/json"})
    public List<Usertable> findBySurnname(@PathParam("surnname") String surnname) {
        Query query = em.createNamedQuery("Usertable.findBySurnname");
        query.setParameter("surnname", surnname);
        return query.getResultList();
    }

    @GET
    @Path("findByEmail/{email}")
    @Produces({"application/json"})
    public List<Usertable> findByEmail(@PathParam("email") String email) {
        Query query = em.createNamedQuery("Usertable.findByEmail");
        query.setParameter("email", email);
        return query.getResultList();
    }
    
    @GET
    @Path("findByDob/{dob}")
    @Produces({"application/json"})
    public List<Usertable> findByDob(@PathParam("dob") String dobstr) throws ParseException {
        Date dob=new SimpleDateFormat("yyyy-MM-dd").parse(dobstr);
        Query query = em.createNamedQuery("Usertable.findByDob");
        query.setParameter("dob", dob);
        return query.getResultList();
    }
    
    @GET
    @Path("findByHeight/{height}")
    @Produces({"application/json"})
    public List<Usertable> findByHeight(@PathParam("height") Integer height) {
        Query query = em.createNamedQuery("Usertable.findByHeight");
        query.setParameter("height", height);
        return query.getResultList();
    }
    
    @GET
    @Path("findByWeight/{weight}")
    @Produces({"application/json"})
    public List<Usertable> findByWeight(@PathParam("weight") Integer weight) {
        Query query = em.createNamedQuery("Usertable.findByWeight");
        query.setParameter("weight", weight);
        return query.getResultList();
    }
    
    @GET
    @Path("findByGender/{gender}")
    @Produces({"application/json"})
    public List<Usertable> findByGender(@PathParam("gender") String gender) {
        Query query = em.createNamedQuery("Usertable.findByGender");
        query.setParameter("gender", gender);
        return query.getResultList();
    }
    
    @GET
    @Path("findByAddress/{address}")
    @Produces({"application/json"})
    public List<Usertable> findByAddress(@PathParam("address") String address) {
        Query query = em.createNamedQuery("Usertable.findByAddress");
        query.setParameter("address", address);
        return query.getResultList();
    }
    
    @GET
    @Path("findByPostcode/{postcode}")
    @Produces({"application/json"})
    public List<Usertable> findByPostcode(@PathParam("postcode") String postcode) {
        Query query = em.createNamedQuery("Usertable.findByPostcode");
        query.setParameter("postcode", postcode);
        return query.getResultList();
    }
    
    @GET
    @Path("findByLeveloffactivity/{leveloffactivity}")
    @Produces({"application/json"})
    public List<Usertable> findByLeveloffactivity(@PathParam("leveloffactivity") Integer leveloffactivity) {
        Query query = em.createNamedQuery("Usertable.findByLeveloffactivity");
        query.setParameter("leveloffactivity", leveloffactivity);
        return query.getResultList();
    }
    
    @GET
    @Path("findByStepspermile/{stepspermile}")
    @Produces({"application/json"})
    public List<Usertable> findByStepspermile(@PathParam("stepspermile") Integer stepspermile) {
        Query query = em.createNamedQuery("Usertable.findByStepspermile");
        query.setParameter("stepspermile", stepspermile);
        return query.getResultList();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Usertable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
