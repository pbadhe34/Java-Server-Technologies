package org.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	
	//http://localhost:8090/REST-PathParams/users/87
	@GET
	@Path("/get/{id},{name}")
	public Response getUserById(@PathParam("id") String id,@PathParam("name") String name) {

		return Response.status(200).entity("getUserById is called, id : " + id+" name = "+name)
				.build();

	}

	//http://localhost:8090/REST-PathParams/users/2007,maruti/December/20
	@GET
	@Path("/{year},{brand}/{month}/{day}")
	public Response getUserHistory(@PathParam("year") int year,
			@PathParam("month") String month, @PathParam("day") int day,@PathParam("brand")
			String brandName) {

		String msg = year + "/" + month + "/" + day +" for "+brandName;

		return Response.status(200)
				.entity("getUserHistory is called, year/month/day : " + msg)
				.build();

	}
	
}