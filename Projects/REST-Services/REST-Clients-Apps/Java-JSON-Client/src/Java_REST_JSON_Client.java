import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection; 
import java.net.URL;

import org.json.JSONObject;

public class Java_REST_JSON_Client {

	public static void main(String[] args) throws IOException {
		System.out.println("*** GET Product as JSON **");
	 
		URL getUrl = new URL("http://localhost:8080/REST-JAXB-JSON-Service/json/product/get");
		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();

		// Get json structure of customer object from the service

		connection = (HttpURLConnection) getUrl.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		// HttpURLConnection.HTTP_OK, connection.getResponseCode());

		System.out.println("The response code is  "
				+ connection.getResponseCode());

		System.out.println("The response content type is "
				+ connection.getContentType());

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream()));
		System.out.println("\nThe JSON format of Product sent by server...\n");

		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		connection.disconnect();

		 

		// post Product json object
	   System.out.println("*** POST Product as JSON **");
			 
		 
		URL postUrl = new URL("http://localhost:8080/REST-JAXB-JSON-Service/json/product/post");

		HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");		 
		// conn.setInstanceFollowRedirects(false);

		 
		//String newCust = "{\"firstName\":\"Vijay\",\"lastName\":\"More\",\"street\":\"MughalStreet\",\"city\":\"Delhi\",\"zip\":\"1222\",\"id\":12,\"state\":\"MP\",\"country\":\"India\"}";

	 
		 
		 //we can also use json translator
		  JSONObject obj = new JSONObject(); 
		  obj.put("name", "Nokia6758");
		  obj.put("qty", 1056);    
		  
		  
		  String dataJson = obj.toString();
		  System.out.println("The product posted is  "+dataJson);		 

		OutputStream os = conn.getOutputStream();
		//os.write(newCust.getBytes());
		os.write(dataJson.getBytes());
		os.flush();
		System.out.println("The http status respopnse in post code is  "
				+ conn.getResponseCode());

		System.out.println("The http response created code is  "
				+ HttpURLConnection.HTTP_CREATED);

		if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output = null;
		System.out.println("Output from the Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		
		 
				 	  
				  

				 


	}

}
