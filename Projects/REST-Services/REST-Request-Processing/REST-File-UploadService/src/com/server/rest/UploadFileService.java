package com.server.rest;

import java.io.File;

//Upload file from command line with curl
//curl -X POST--upload-file <fileName>  http://localhost:8090/REST-File-UploadService/fileServer/upload
	
//curl -X POST -H 'Content-Type:multipart/form-data' -F Actions.txt http://localhost:8090/REST-File-UploadService/fileServer/upload

	
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/fileServer")
public class UploadFileService {

	private final String UPLOAD_FILE_PATH = "d:\\MyFiles\\";
	
	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(MultipartFormDataInput input) {

		String fileName = "";
		
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("uploadedFile");

		System.out.println("Finding upload file details");
		for (InputPart inputPart : inputParts) {

			try {

				System.out.println("Trying to  upload file details");
				MultivaluedMap<String, String> header = inputPart.getHeaders();
				fileName = getFileName(header);
				System.out.println("The file uploaded is "+fileName);

				//convert the uploaded file to inputstream
				InputStream inputStream = inputPart.getBody(InputStream.class,null);

				byte [] bytes = IOUtils.toByteArray(inputStream);
				
				//constructs upload file path
				fileName = UPLOAD_FILE_PATH + fileName;
				
				writeFile(bytes,fileName);
				
				System.out.println("Done uploading with file  "+fileName);

			} catch (IOException e) {
				//e.printStackTrace();
				System.out.println("The error caught is  "+e.getMessage());
			}

		}
		return Response.status(200)
				.entity("uploadFile is success witth uploaded file name : " + fileName).build();

	}

	@GET
	@Path("/test")
	@Produces("text/plain")
	public Response testResponse() {
		return Response.status(200)
		.entity("Success").build();
	}

	/**
	 * header sample
	 * {
	 * 		Content-Type=[image/png], 
	 * 		Content-Disposition=[form-data; name="file"; filename="filename.extension"]
	 * }
	 **/
	//get uploaded filename, is there a easy way in RESTEasy?
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");
				
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	//save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}
}