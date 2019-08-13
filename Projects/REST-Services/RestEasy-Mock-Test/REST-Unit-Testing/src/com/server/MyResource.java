package com.server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

 

 

@Path("upload")
public class MyResource {
	
	    /*private BackendService backendService;

        public BackendService getBackendService() {
			return backendService;
		}

		public void setBackendService(BackendService backendService) {
			this.backendService = backendService;
		}*/

		@POST
        @Consumes(MediaType.TEXT_PLAIN)
        @Produces(MediaType.APPLICATION_XML)
        public MyModel createMyModel(int number) {

        	// return backendService.getMyModel(number);
            return new MyModel(number);
        }

   

}
