import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

public class AsyncJobTest {

	public static void main(String args[]) throws Exception {
		//testSimple();
	    testAsynch();
	}

	public static void testSimple() throws Exception {

		ClientRequest request = new ClientRequest("http://localhost:8090/REST-Async-Service/services/resource");
		ClientResponse<String> response = request.get(String.class);
		System.out.println("The response status  in testSimple get is  " + response.getStatus());

		System.out.println("The response in testsimple get is  " + response.getEntity());
		
		System.out.println("The response is waiting for  testsimple put .... " );
		
		/*Status : 202: Accepted

		The request has been accepted for processing, but the processing has not been completed
		Status :  204: No Content

        The server has fulfilled the request but does not need to return an entity-body, and might want to return updated metainformation. 
        The response MAY include new or updated metainformation in the form of entity-headers, which if present SHOULD be associated with the requested variant. 
		*
		*/

		
		//request = new ClientRequest("http://localhost:8090/REST-Async-Service/services/resource");
		
		
		request = new ClientRequest
				("http://localhost:8090/REST-Async-Service/services/resource?oneway=true");
		
		request.body("text/plain", "The data to be updated");
		response = request.put(String.class);

		System.out.println("The response status  in testSimple put is  " + response.getStatus());
		
		
		System.out.println("The response in testsimple put  is  " + response.getEntity());
		
		Thread.sleep(22000);
		
		System.out.println("The final response in testsimple put  is  " + response.getEntity());
		
		response.releaseConnection();

	}

	public static void testAsynch() throws Exception {
		ClientRequest request = new ClientRequest("http://localhost:8090/REST-Async-Service/services?asynch=true");
		request.body("text/plain", "The data to be posted");
		System.out.println("The client is waiting for the response in post request ");
		ClientResponse<String> response = request.post(String.class);

		System.out.println("The initial response status  in testAsynch is  " + response.getStatus());

		String jobUrl1 = response.getResponseHeaders().getFirst(HttpHeaders.LOCATION);
		System.out.println("jobUrl1 : " + jobUrl1);
		response.releaseConnection();

		request = new ClientRequest(jobUrl1);
		response = request.get(String.class);
		System.out.println("The response status  in testAsynch is  " + response.getStatus());
		// Response.Status.ACCEPTED.getStatusCode()
		response.releaseConnection();

		Thread.sleep(15000);
		response = request.get(String.class);
		System.out.println("The response stautus after delay in testAsynch is  " + response.getStatus());

		System.out.println("The final response in testAsync is  " + response.getEntity());

	}
}
