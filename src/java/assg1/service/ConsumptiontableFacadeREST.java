/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1.service;

import assg1.Consumptiontable;
import assg1.Foodtable;
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
@Path("assg1.consumptiontable")
public class ConsumptiontableFacadeREST extends AbstractFacade<Consumptiontable> {

    @PersistenceContext(unitName = "fitappPU")
    private EntityManager em;

    public ConsumptiontableFacadeREST() {
        super(Consumptiontable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Consumptiontable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Consumptiontable entity) {
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
    public Consumptiontable find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByCdate/{cdate}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByCdate(@PathParam("cdate") String datestr) throws ParseException {
        Date cdate=new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
        Query query = em.createNamedQuery("Consumptiontable.findByCdate");
        query.setParameter("cdate", cdate);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingunit/{servingunit}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByServingunit(@PathParam("servingunit") String servingunit) {
        Query query = em.createNamedQuery("Consumptiontable.findByServingunit");
        query.setParameter("servingunit", servingunit);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingamount/{servingamount}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByServingamount(@PathParam("servingamount") Integer servingamount) {
        Query query = em.createNamedQuery("Consumptiontable.findByServingamount");
        query.setParameter("servingamount", servingamount);
        return query.getResultList();
    }
    

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumptiontable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findByFoodIdName/{foodid}/{foodname}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByFid(@PathParam("foodid") Integer foodid, @PathParam("foodname") String foodname) {
        TypedQuery<Consumptiontable> q = em.createQuery("SELECT s FROM Consumptiontable s WHERE s.foodid.id = :foodid AND s.foodid.foodname = :foodname", Consumptiontable.class);
        q.setParameter("foodid", foodid);
        q.setParameter("foodname", foodname);
        return q.getResultList();
    }
    
    @GET
    @Path("findByFidAName/{foodid}/{foodname}")
    @Produces({"application/json"})
    public List<Consumptiontable> findByFidAName(@PathParam("foodid") Integer foodid, @PathParam("foodname") String foodname) {
        Query query = em.createNamedQuery("Consumptiontable.findByFidAName");
        query.setParameter("foodid", foodid);
        query.setParameter("foodname", foodname);
        return query.getResultList();
    }
    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consumptiontable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
