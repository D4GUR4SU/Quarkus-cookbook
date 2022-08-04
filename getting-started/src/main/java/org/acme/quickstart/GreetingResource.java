package org.acme.quickstart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
        @Context UriInfo uriInfo,
        @QUeryParam("order") Order order,
        @NotBlank @HeaderParameter("authorization") String authorization
    ) {

        return String.format("URI: %s - Order %s - Authorization: %s",
        uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void create(String message){
        System.outr.println("Create")
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String update(String message){
        System.out.println("Update");
        return message;
    }

    @DELETE
    public void delete(String message){
        System.out.println("Delete");
    }
}