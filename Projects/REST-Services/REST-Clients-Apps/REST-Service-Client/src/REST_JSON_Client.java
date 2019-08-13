import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection; 
import java.net.URL;

import org.json.JSONObject;

public class REST_JSON_Client {

	public static void main(String[] args) throws IOException {
		System.out.println("*** GET Customer as JSON **");
	 
		URL getUrl = new URL("http://localhost:8080/REST-JSON-WADL/customers/");
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
		System.out.println("\nThe JSON format of customer sent by server...\n");

		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		connection.disconnect();

		// Get the structure of customer object as plain text		
		
		 /* System.out.println("\n*** GET Customer as plain text **\n");
		  connection = (HttpURLConnection) getUrl.openConnection();
		  connection.setRequestMethod("GET");
		  connection.setRequestProperty("Accept", "text/plain");
		  System.out.println
		  ("The response code is  "+connection.getResponseCode());
		  
		  System.out.println("The response content type is "+connection.
		  getContentType());
		  
		  System.out.println("The customer recd as plain text format is \n");
		  reader = new BufferedReader(new
		  InputStreamReader(connection.getInputStream()));
		  
		  line = reader.readLine(); while (line != null) {
		  System.out.println(line); line = reader.readLine(); }
		  
		  connection.disconnect();
		 */

		// post customer json object
	   /*System.out.println("*** POST Customer as JSON **");
			 
		 
		URL postUrl = new URL("http://localhost:8080/REST-JSON-WADL/customers/");

		HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");		 
		// conn.setInstanceFollowRedirects(false);

		 
		//String newCust = "{\"firstName\":\"Vijay\",\"lastName\":\"More\",\"street\":\"MughalStreet\",\"city\":\"Delhi\",\"zip\":\"1222\",\"id\":12,\"state\":\"MP\",\"country\":\"India\"}";

	 
		//System.out.println("The new customer is  " + newCust);

		 //we can also use json translator
		  JSONObject obj = new JSONObject(); 
		  obj.put("firstName", "Vijay");
		  obj.put("lastName", "Mourya"); 
		  obj.put("street", "MughalStreet");
		  obj.put("city", "Delhi"); 
		  obj.put("zip", "1111");
		  
		  obj.put("id", "14"); 
		  obj.put("state", "MP"); 
		  obj.put("country", "india");
		  
		  
		  String dataJson = obj.toString();
		  System.out.println("The oputput sent is  "+dataJson);		 

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

		conn.disconnect();*/
		
		// Update customer json object
		   System.out.println("*** Update Customer as JSON **");
				 
			 
			URL updateUrl = new URL("http://localhost:8080/REST-JSON-WADL/customers/1");

			HttpURLConnection conn2 = (HttpURLConnection) updateUrl.openConnection();
			conn2.setDoOutput(true);
			conn2.setRequestMethod("PUT");
			conn2.setRequestProperty("Content-Type", "application/json");		 
			// conn.setInstanceFollowRedirects(false);

			 
		//	String updateCustomer = "{\"firstName\":\"Vijay\",\"lastName\":\"More\",\"street\":\"MughalStreet\",\"city\":\"Delhi\",\"zip\":\"1222\",\"id\":12,\"state\":\"MP\",\"country\":\"India\"}";

		 
			//System.out.println("The new customer is  " + newCust);

			 //we can also use json translator
			  JSONObject obj1 = new JSONObject(); 
			  obj1.put("firstName", "Poi");
			  obj1.put("lastName", "Bgg"); 
			  obj1.put("street", "Up Road");
			  obj1.put("city", "Kanpur"); 
			  obj1.put("zip", "1234");
			  
			  obj1.put("id", "1"); 
			  obj1.put("state", "MP"); 
			  obj1.put("country", "india");
			  
			  
			  String dataJson1 = obj1.toString();
			  System.out.println("The oputput sent is  "+dataJson1);
			 

			OutputStream os1 = conn2.getOutputStream();			 
			os1.write(dataJson1.getBytes());
			os1.flush();
			System.out.println("The http status respopnse in post code is  "
					+ conn2.getResponseCode());

			System.out.println("The http response created code is  "
					+ HttpURLConnection.HTTP_CREATED);

			 

			BufferedReader br2 = new BufferedReader(new InputStreamReader(
					(conn2.getInputStream())));

			String output = null;
			System.out.println("Output from the Server .... \n");
			while ((output = br2.readLine()) != null) {
				System.out.println(output);
			}

			conn2.disconnect();
			
			
			// Delete customer json object
			   System.out.println("*** Delete Customer as JSON **");
					 
				 
				URL deleteUrl = new URL("http://localhost:8080/REST-JSON-WADL/customers/2");

				HttpURLConnection con = (HttpURLConnection) deleteUrl.openConnection();
				con.setDoOutput(true);
				con.setRequestMethod("DELETE");
				//con.setRequestProperty("Content-Type", "application/json");		 
				// con.setInstanceFollowRedirects(false);

				System.out.println("The response code in delete opeartion is  "
						+ con.getResponseCode());

				System.out.println("The response content type is "
						+ con.getContentType());

				BufferedReader reader2 = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				
				line = null;			 
				line = reader2.readLine();
				while (line != null) {
					System.out.println(line);
					line = reader2.readLine();
				}
				con.disconnect();
			 
			 
				 	  
				  

				 


	}

}
