package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

//The Loader class  org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher
@Path("/user")
public class ServiceClass {

    @GET
    @Path("/test")
    public Response getResponse() {

        String value = "Welcome to the web!";

        return Response.status(200).entity(value).build();
    }
}
