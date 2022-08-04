package org.acme.quickstart;


import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    // First way to to user reactive routes
    public void routes(@Observes Router router){
        router
            .get("/ok")
            .handler(rc -> rc.response().end("OK from route"));
    }

    // Second way to use reactive routes
    @Route(path = "/declarativeok", methods = HttpMethod.GET)
    public void greetings(RoutingContext routingContext){
        String name = routingContext.request().getParam("name");
        if(name == null){
            name = "world";
        }

        routingContext.response().end("OK " + name + " you are right");
    }
}
