package org.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

 
@Path("/services")
public class MyResource
{
   private static int count = 0;


   @POST
   @Produces("text/plain")
   @Consumes("text/plain")
   public String post(String content) throws Exception
   {
	   count++;
	   System.out.println("MyResource.post()");	 
      Thread.sleep(10000);
      return "From server "+content;
   }

   @GET
   @Path("/resource")
   @Produces("text/plain")
   public String get() throws InterruptedException
   {
	   count++;
	   System.out.println("MyResource.get()");	    
       return Integer.toString(count);
   }

   @PUT
   @Consumes("text/plain")
   public void put(String content) throws Exception
   {
      System.out.println("IN PUT Contenbt received is  "+content);
      count++;
      Thread.sleep(20000);
      System.out.println("******* countdown complete ****");
      count++;
   }
}
