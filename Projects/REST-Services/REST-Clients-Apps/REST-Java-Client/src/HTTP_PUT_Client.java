import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class HTTP_PUT_Client {

	public static void main(String[] args) throws IOException {
		 
	
		// Update customer json object
		System.out.println("*** Update Person as JSON **");

		URL updateUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/update");
		HttpURLConnection conn2 = (HttpURLConnection) updateUrl.openConnection();
		conn2.setDoOutput(true);
		conn2.setRequestMethod("PUT");
		conn2.setRequestProperty("Content-Type", "application/json");
		// conn.setInstanceFollowRedirects(false);

		String updatePerson = "{\"id\":1,\"name\":\"Naja\",\"country\":\"Cge\"}";
		 System.out.println("The upadate person is " + updatePerson);

		// we can also use json translator
		JSONObject obj1 = new JSONObject();
		obj1.put("name", "Tanvir");	 

		obj1.put("id", "2");
		 
		obj1.put("country", "india");
		String dataJson1 = obj1.toString();
		System.out.println("The oputput sent is  " + dataJson1);

		OutputStream os1 = conn2.getOutputStream();
		os1.write(updatePerson.getBytes());
		//os1.write(dataJson1.getBytes());
		os1.flush();
		System.out.println("The http status respopnse in post code is  " + conn2.getResponseCode());

		System.out.println("The http response created code is  " + HttpURLConnection.HTTP_CREATED);

		BufferedReader br2 = new BufferedReader(new InputStreamReader((conn2.getInputStream())));

		String output = null;
		System.out.println("Output from the Server .... \n");
		while ((output = br2.readLine()) != null) {
			System.out.println(output);
		}

		conn2.disconnect();

		 
	}

}
