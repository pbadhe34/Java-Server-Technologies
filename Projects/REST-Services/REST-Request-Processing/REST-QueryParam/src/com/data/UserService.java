package com.data;

import java.util.List;

//http://localhost:8080/REST-QueryParam/userData/query?from=123&to=67&orderBy=test&orderBy=datadd
//http://localhost:8080/REST-QueryParam/userData/test?from=123&to=67&orderBy=test&orderBy=datadd

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/userData")
public class UserService {

	@GET
	@Path("/query")
	public Response getUsers(@DefaultValue("1000") @QueryParam("from") int from,
			@DefaultValue("999")@QueryParam("to") int to,
			@DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}
	
	@GET
	@Path("/test")
	public Response getUsers(@Context UriInfo info) {

		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");
		List<String> orderBy = info.getQueryParameters().get("orderBy");
		
		return Response
				.status(200)
				.entity("getUsers is called with @Context, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	} 

}