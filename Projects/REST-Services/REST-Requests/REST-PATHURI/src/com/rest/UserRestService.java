package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	@GET
	public Response getUser() {

		return Response.status(200).entity("getUser with default sub-path is called").build();

	}

	@GET
	@Path("/vip")
	public Response getUserVIP() {

		return Response.status(200).entity("getUserVIP path is called").build();

	}

	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {

		return Response.status(200)
				.entity("getUserByName is called with path param as , name : " + name).build();

	}

	/*//Only integer numbers here
			@GET
			@Path("{num1}")
			public Response getUserByNumId(@PathParam("num1") int data) {

				return Response.status(200).entity("getUserByNumberId with @PathParam is called, with number as id : " + data)
						.build();

			}*/
			
			
	//Only numbers please restricted by Regular Expression
	@GET
	@Path("{id : \\d+}")
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("getUserById with @PathParam is called, with number as id : " + id)
				.build();

	}
	
	 

	//only two letter username with combination of chars  is allowed
	//Only second char can be a number
	//http://localhost:8090/REST-PATHURI/users/username/a1
	
	//http://localhost:8090/REST-PATHURI/users/username/1A
	
	// only two letter word with charcdatwers and last numbers if any
	//@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	
	//Now only two letter word with charcdatwers and not numbers
	
	//Only first letter as Caps and second as lower case
	
	//@Path("/username/{username : [A-Z][a-z]}")
	
	@GET
	@Path("/username/{name : [A-Z][a-z]}")
	public Response getUserByUserName(@PathParam("name") String Uname) {

		return Response.status(200)
				.entity("getUserByUserName is called, username : " + Uname)
				.build();

	}

	//Only number in string format is allowed hetre
	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

		return Response.status(200)
				.entity("getUserBookByISBN is called, isbn : " + isbn).build();

	}

}