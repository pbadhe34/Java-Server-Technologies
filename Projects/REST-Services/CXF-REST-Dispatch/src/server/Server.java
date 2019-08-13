package server;

 

import javax.xml.ws.Endpoint;
import javax.xml.ws.http.HTTPBinding;

public class Server {

    protected Server() throws Exception {
        System.out.println("Starting Server");
        Endpoint e = Endpoint.create(HTTPBinding.HTTP_BINDING, new RestSourcePayloadProvider());
        String address = "http://localhost:9000/customerservice/customer";
        e.publish(address);
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
