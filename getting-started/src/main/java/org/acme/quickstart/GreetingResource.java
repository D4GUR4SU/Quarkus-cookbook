package org.acme.quickstart;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingResource {

    public static enum Order{
        asc, desc;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
        @Context UriInfo uriInfo,
        @QueryParam("order") Order order,
        @NotBlank @HeaderParam("authorization") String authorization
    ) {

        return String.format("URI: %s - Order %s - Authorization: %s",
        uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void create(String message){
        System.out.println("Create");
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

    @LOCK
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public String lockResource(@PathParam("id") long id){
        return id + " locked";
    }
}