import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class HTTP_Delete_Client {

	public static void main(String[] args) throws IOException {	 
	
		 
		// Delete customer json object
		System.out.println("*** Delete Person as JSON **");

		URL deleteUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/remove/2");

		HttpURLConnection con = (HttpURLConnection) deleteUrl.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("DELETE");
		// con.setRequestProperty("Content-Type", "application/json");
		// con.setInstanceFollowRedirects(false);

		System.out.println("The response code in delete opeartion is  " + con.getResponseCode());

		System.out.println("The response content type is " + con.getContentType());

		BufferedReader reader2 = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String line = null;
		line = reader2.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader2.readLine();
		}
		con.disconnect();
	}

}
