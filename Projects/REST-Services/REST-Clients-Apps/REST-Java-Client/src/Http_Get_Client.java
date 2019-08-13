
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Http_Get_Client {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		  

	      // Get the  customer from the uri
	      
	     // URL getUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/list");
	     // URL getUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/get/2");
	       URL getUrl = new URL("http://localhost:8095/Spring-REST-JSON/rest/person/get?id=2");
	      HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
	      connection.setRequestMethod("GET");
	      connection.setRequestProperty("Accept", "application/json");

	      System.out.println("Content-Type: " + connection.getContentType());

	      BufferedReader reader = new BufferedReader(new
	              InputStreamReader(connection.getInputStream()));

	      String line = reader.readLine();
	      while (line != null)
	      {
	         System.out.println(line);
	         line = reader.readLine();
	      }
	      System.out.println("The  response code is  "+connection.getResponseCode());
	      connection.disconnect();



	}

}
