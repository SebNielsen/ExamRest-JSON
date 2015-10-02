/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import TestDataGenerator.DataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author sebastiannielsen
 */
@Path("adresses")
public class RestService {
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    public RestService() {
    }

    @GET
    @Path("{number:[0-9]+}/{properties}")
    @Produces("application/json")
    public Response getTestData(@PathParam("number") int amount, @PathParam("properties") String properties) {
        
        String data = DataGenerator.getData(amount, properties);
        System.out.println(data);
        return Response.status(Response.Status.OK).entity(data).build();
    }

}
