import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class HTTP_Post_Client {

	public static void main(String[] args) throws IOException {
		 

		// post new customer as json object
		System.out.println("*** POST Person as JSON **");

		URL postUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/add");

		HttpURLConnection conn = (HttpURLConnection) postUrl.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		
		String newPerson = "{\"name\":\"Baba\",\"country\":\"Bars\"}";
		 
		// System.out.println("The new Person string to be sent is " + newCust);

		// we can also use json translator
		JSONObject obj = new JSONObject();
		obj.put("name", "Vijay");	 
		 
		obj.put("country", "india");

		String dataJson = obj.toString();
		//System.out.println("The oputput json object sent is  " + dataJson);

		OutputStream os = conn.getOutputStream();
		os.write(newPerson.getBytes());
		//os.write(dataJson.getBytes());
		os.flush();
		System.out.println("The http status respopnse in post code is  " + conn.getResponseCode());

		//System.out.println("The http response created code is  " + HttpURLConnection.HTTP_CREATED);

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output = null;
		System.out.println("Output from the Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();		
		 
	}

}
