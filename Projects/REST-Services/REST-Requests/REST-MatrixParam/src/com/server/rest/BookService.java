package com.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

///books/book//2011;author=viju

//“/books/book/2012;author=Stefen Hawkins,John TRavolta;country=USA

///books/book/2014;country=brazil;author=Karlson
//http://localhost:8090/REST-MatrixParam/books/readAll;author=Stefen-Hawkins,John-Travolta;country=USA


//matrix params  features:

/*more readable
no encoding and decoding of "&" in XML documents is required
URLs with "?" are not cached in many cases; URLs with matrix params are cached
matrix parameters can appear everywhere in the path and are not limited to its end
matrix parameters can have more than one value: paramA=val1,val2*/


@Path("/books")
public class BookService {

	private final static Logger logger = Logger.getLogger(com.server.rest.BookService.class);
	@GET
	@Path("/book/{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		 System.out.println("The getBooks is here");
		return Response
				.status(200)
				.entity("getBooks is called, year : " + year
						+ ", author : " + author + ", country : " + country)
				.build();

	}
	
	//http://localhost:8090/REST-MatrixParam/books/readAll;country=brazil;author=Karlson,jj;test=uu
	
	@GET
    @Path("/readAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrders(@Context UriInfo info){

		int num = info.getPathSegments().size();
		System.out.println("No of path segments are  : " + num);
        PathSegment model = info.getPathSegments().get(1);
        System.out.println("first path segment : " + model.getPath());
        PathSegment model2 = info.getPathSegments().get(0);
        System.out.println("second path segment : " + model2.getPath());
        System.out.println("Read all matrix params ");
        for (String name : model.getMatrixParameters().keySet()){
            String value = model.getMatrixParameters().getFirst(name);
            logger.info("\tMatrix param name: " + name + " value: " + value);
            System.out.println("\tMatrix param name: " + name + " value: " + value);
        }

       // return Response.ok().build();
        
        return Response
				.ok("All Matrix Params read")
				.build();
    }

}