import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class REST_XML_Client_Post {

	 
	public static void main(String[] args) throws IOException {
		System.out.println("*** Create a new User and upload it***");
	      // Create a new customer
	      String newUser = "<user pin=\"7689\"><password>sektret56</password><username>Ashok</username></user>";

	      URL postUrl = new URL("http://localhost:8080/REST-XML-JAXB-Service/xml/user/post");
	      HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
	      connection.setDoOutput(true);
	      connection.setInstanceFollowRedirects(false);
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/xml");
	      OutputStream os = connection.getOutputStream();
	      os.write(newUser.getBytes());
	      os.flush();
	      System.out.println("The http status respopnse code is  "+connection.getResponseCode());
	      
	     // System.out.println("Location: " + connection.getHeaderField("Location"));
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));

			String output = null;
			System.out.println("Output from the Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	      connection.disconnect();



	}

}
