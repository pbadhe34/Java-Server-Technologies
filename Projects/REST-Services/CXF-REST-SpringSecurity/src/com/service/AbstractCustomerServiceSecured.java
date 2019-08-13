 
package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/customerservice/") 
@Produces("application/xml")
public abstract class AbstractCustomerServiceSecured implements CustomerServiceSecured {
    
    protected long currentId = 123;
    protected Map<Long, Customer> customers = new HashMap<Long, Customer>();
    protected Map<Long, Order> orders = new HashMap<Long, Order>();

    protected AbstractCustomerServiceSecured() {
        init();
    } 

    @GET
    @Path("/customers/{id}/")
    public abstract Customer getCustomer(@PathParam("id") String id);

    @PUT
    @Path("/customers/{id}")
    public abstract Response updateCustomer(@PathParam("id") Long id, Customer customer);
    
    @POST
    @Path("/customers/")
    public abstract Response addCustomer(Customer customer);

    @DELETE
    @Path("/customers/{id}/")
    public abstract Response deleteCustomer(@PathParam("id") String id);

    @Path("/orders/{orderId}/")
    public abstract Order getOrder(@PathParam("orderId") String orderId);

    private void init() {
        Customer c = new Customer();
        c.setName("kopni");
        c.setId(123);
        customers.put(c.getId(), c);

        Order o = new Order();
        o.setDescription("order 223");
        o.setId(223);
        orders.put(o.getId(), o);
    }

}
