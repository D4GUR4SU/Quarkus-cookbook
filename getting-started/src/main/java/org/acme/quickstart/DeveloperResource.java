package org.acme.quickstart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/developer")
public class DeveloperResource {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createDeveloper(Developer developer) {
    developer.persist();

    return Response.created(UriBuilder
        .fromResource(DeveloperResource.class)
        .path(Long.toString(developer.getId()))
        .build())
        .entity(developer)
        .build();
  }

  public static class Developer {

    static Long counter = Long.valueOf(1);

    private Long id;
    private String name;

    public Long getId() {
      return id;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void persist() {
      this.id = counter++;
    }
  }
}
