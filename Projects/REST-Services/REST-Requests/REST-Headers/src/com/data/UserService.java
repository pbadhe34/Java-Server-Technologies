package com.data;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserService {

	@GET
	@Path("/getHeaders")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("addUser is called from userAgent : " + userAgent)
				.build();

	}
	
	@GET
    @Path("/allHeaders")
    public Response queryHeaderInfo(@Context HttpHeaders httpHeaders){
         
        /** To get specific header info **/
        String cacheControl = httpHeaders.getRequestHeader("Cache-Control").get(0);
        System.out.println("Cache-Control: "+cacheControl);

System.out.println("Read aall headers");
        /** get list of all header parameters from request **/
        Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
        for(String header:headerKeys){
            System.out.println(header+":"+httpHeaders.getRequestHeader(header).get(0));
        }
        return Response.status(200).entity("successfully queried header info").build();
    } 

}