/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assg1.service;

import assg1.Foodtable;
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
@Path("assg1.foodtable")
public class FoodtableFacadeREST extends AbstractFacade<Foodtable> {

    @PersistenceContext(unitName = "fitappPU")
    private EntityManager em;

    public FoodtableFacadeREST() {
        super(Foodtable.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Foodtable entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Foodtable entity) {
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
    public Foodtable find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("findByCategory/{category}")
    @Produces({"application/json"})
    public List<Foodtable> findByCategory(@PathParam("category") String
        category) {
    Query query = em.createNamedQuery("Foodtable.findByCategory");
    query.setParameter("category", category);
    return query.getResultList();
    }
    
    @GET
    @Path("findByFoodname/{foodname}")
    @Produces({"application/json"})
    public List<Foodtable> findByFoodname(@PathParam("foodname") String
        foodname) {
    Query query = em.createNamedQuery("Foodtable.findByFoodname");
    query.setParameter("foodname", foodname);
    return query.getResultList();
    }
    
    @GET
    @Path("findByCalamount/{calamount}")
    @Produces({"application/json"})
    public List<Foodtable> findByCalamount(@PathParam("calamount") Integer calamount) {
        Query query = em.createNamedQuery("Foodtable.findByCalamount");
        query.setParameter("calamount", calamount);
        return query.getResultList();
    }
    
    @GET
    @Path("findByServingunit/{servingunit}")
    @Produces({"application/json"})
    public List<Foodtable> findByServingunit(@PathParam("servingunit") String
        servingunit) {
    Query query = em.createNamedQuery("Foodtable.findByServingunit");
    query.setParameter("servingunit", servingunit);
    return query.getResultList();
    }

    @GET
    @Path("findByServingamount/{servingamount}")
    @Produces({"application/json"})
    public List<Foodtable> findByServingamount(@PathParam("servingamount") Integer servingamount) {
        Query query = em.createNamedQuery("Foodtable.findByServingamount");
        query.setParameter("servingamount", servingamount);
        return query.getResultList();
    }
    
    @GET
    @Path("findByFat/{fat}")
    @Produces({"application/json"})
    public List<Foodtable> findByFat(@PathParam("fat") Integer fat) {
        Query query = em.createNamedQuery("Foodtable.findByFat");
        query.setParameter("fat", fat);
        return query.getResultList();
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Foodtable> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Foodtable> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("findByCategory2/{foodname}/{category}")
    @Produces({"application/json"})
    public List<Foodtable> findByCategory2(@PathParam("foodname") String
        foodname,@PathParam("category") String category) {
            TypedQuery<Foodtable> q = em.createQuery("SELECT s FROM Foodtable s WHERE s.category = :category AND s.foodname = :foodname", Foodtable.class);
            q.setParameter("foodname", foodname);
            q.setParameter("category", category);
            return q.getResultList();
    }
    

}
