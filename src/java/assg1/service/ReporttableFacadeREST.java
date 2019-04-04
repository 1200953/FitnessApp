/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1.service;

import assg1.Reporttable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("assg1.reporttable")
public class ReporttableFacadeREST extends AbstractFacade<Reporttable> {

    @PersistenceContext(unitName = "fitappPU")
    private EntityManager em;

    public ReporttableFacadeREST() {
        super(Reporttable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Reporttable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Reporttable entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("findByRdate/{rdate}")
    @Produces({"application/json"})
    public List<Reporttable> findByRdate(@PathParam("rdate") String rdatestr) throws ParseException {
        Date rdate=new SimpleDateFormat("yyyy-MM-dd").parse(rdatestr);
        Query query = em.createNamedQuery("Reporttable.findByRdate");
        query.setParameter("rdate", rdate);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCalconsumed/{calconsumed}")
    @Produces({"application/json"})
    public List<Reporttable> findByServingunit(@PathParam("calconsumed") Integer calconsumed) {
        Query query = em.createNamedQuery("Reporttable.findByCalconsumed");
        query.setParameter("calconsumed", calconsumed);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCalburned/{calburned}")
    @Produces({"application/json"})
    public List<Reporttable> findByCalburned(@PathParam("calburned") Integer calburned) {
        Query query = em.createNamedQuery("Reporttable.findByCalburned");
        query.setParameter("calburned", calburned);
        return query.getResultList();
    }
    
    @GET
    @Path("findByStepstaken/{stepstaken}")
    @Produces({"application/json"})
    public List<Reporttable> findByStepstaken(@PathParam("stepstaken") Integer stepstaken) {
        Query query = em.createNamedQuery("Reporttable.findByStepstaken");
        query.setParameter("stepstaken", stepstaken);
        return query.getResultList();
    }
    
    @GET
    @Path("findByCalgoal/{calgoal}")
    @Produces({"application/json"})
    public List<Reporttable> findByCalgoal(@PathParam("calgoal") Integer calgoal) {
        Query query = em.createNamedQuery("Reporttable.findByCalgoal");
        query.setParameter("calgoal", calgoal);
        return query.getResultList();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Reporttable find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Reporttable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Reporttable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
