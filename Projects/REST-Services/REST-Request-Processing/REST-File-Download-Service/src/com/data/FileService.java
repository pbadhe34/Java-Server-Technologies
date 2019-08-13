package com.data;

import java.io.File;
import java.io.FileNotFoundException;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/file")
public class FileService {

	private static final String DownloadDir = "d:\\MyFiles\\";

	//http://localhost:8090/REST-File-Download-Service/file/get?fileName=test.docx
		
	@GET
	@Path("/get")
	@Produces("text/plain")
	public Response getFile(@QueryParam("fileName") String downloadFile) {
		File file = null;
		System.out.println("Starting to download file as "+downloadFile);
		try{
    	    file = new File(DownloadDir+downloadFile);
    	    if(file.exists())
    	    {
    	    	System.out.println("The file is available");
    	    }
    	    else  throw new FileNotFoundException();
    	  
       }
       catch(FileNotFoundException e){
    	   System.out.println("The requested file doesnott exist");
    	  // return Response.noContent().build();    	    
    	   return Response.ok("The requested file is not available").build();
    	   
       }
		
       System.out.println("file requested to download is "+downloadFile);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename="+downloadFile);
		return response.build();

	}

}