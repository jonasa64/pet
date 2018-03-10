/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;
import com.google.gson.Gson;
import facade.PetFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jonas
 */
@Path("animals")
public class Pet {
EntityManagerFactory emf;
    PetFacade pf;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Pet
     */
    public Pet() {
        this.emf =  Persistence.createEntityManagerFactory("com.mycompany_RestSpApi_war_1.0-SNAPSHOTPU");
        this.pf = new PetFacade(emf);
    }

    /**
     * Retrieves representation of an instance of Rest.Pet
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
      List<entity.Pet> pet = pf.getPets();
        
        return  new Gson().toJson(pet);
    }

    /**
     * PUT method for updating or creating an instance of Pet
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
