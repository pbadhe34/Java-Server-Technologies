

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Client_URLParams {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		DefaultHttpClient client = new DefaultHttpClient();

	      System.out.println("****Get  CarResource Via @MatrixParam ***");
	      HttpGet get = new HttpGet("http://localhost:8080/Http_UrlParams_REST/cars/matrix/mercedes/e55;color=black/2006");
	      HttpResponse response = client.execute(get);
	      System.out.println("The response code is  "+ response.getStatusLine().getStatusCode());
	      BufferedReader reader = new BufferedReader(new
	              InputStreamReader(response.getEntity().getContent()));

	      String line = reader.readLine();
	      while (line != null)
	      {
	         System.out.println(line);
	         line = reader.readLine();
	      }

	      System.out.println("**** CarResource Via PathSegment ***");
	      get = new HttpGet("http://localhost:8080/Http_UrlParams_REST/cars/segment/mercedes/e55;color=black/2006");
	      response = client.execute(get);
	      System.out.println("The response code is  "+response.getStatusLine().getStatusCode());
	      reader = new BufferedReader(new
	              InputStreamReader(response.getEntity().getContent()));

	      line = reader.readLine();
	      while (line != null)
	      {
	         System.out.println(line);
	         line = reader.readLine();
	      }

	      System.out.println("**** CarResource Via PathSegments ***");
	      get = new HttpGet("http://localhost:8080/Http_UrlParams_REST/cars/segments/mercedes/e55/amg/year/2006");
	      response = client.execute(get);
	      System.out.println("The response code is  "+response.getStatusLine().getStatusCode());
	      reader = new BufferedReader(new
	              InputStreamReader(response.getEntity().getContent()));

	      line = reader.readLine();
	      while (line != null)
	      {
	         System.out.println(line);
	         line = reader.readLine();
	      }

	      System.out.println("**** CarResource Via PathSegment ***");
	      get = new HttpGet("http://localhost:8080/Http_UrlParams_REST/cars/uriinfo/mercedes/e55;color=black/2006");
	      response = client.execute(get);
	      System.out.println("The response code is  "+response.getStatusLine().getStatusCode());
	      reader = new BufferedReader(new
	              InputStreamReader(response.getEntity().getContent()));

	      line = reader.readLine();
	      while (line != null)
	      {
	         System.out.println(line);
	         line = reader.readLine();
	      }
	      System.out.println();
	      System.out.println();


	}

}
