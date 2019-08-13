 package com.service;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class CustomerServiceSecuredImpl extends AbstractCustomerServiceSecured {

    public CustomerServiceSecuredImpl() {
    }

    public Customer getCustomer(String id) {
        System.out.println("----invoking getCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.get(idNumber);
        return c;
    }

    public Response updateCustomer(Long id, Customer customer) {
        System.out.println("----invoking updateCustomer, Customer name is: " + customer.getName());
        Customer c = customers.get(id);
        if (c == null || c.getId() != customer.getId()) {
            throw new WebApplicationException();
        }
        customers.put(customer.getId(), customer);
        return Response.ok(customer).build();
    }

    public Response addCustomer(Customer customer) {
        System.out.println("----invoking addCustomer, Customer name is: " + customer.getName());
        customer.setId(++currentId);

        customers.put(customer.getId(), customer);

        return Response.ok(customer).build();
    }

    public Response deleteCustomer(String id) {
        System.out.println("----invoking deleteCustomer, Customer id is: " + id);
        long idNumber = Long.parseLong(id);
        Customer c = customers.remove(idNumber);

        Response r;
        if (c != null) {
            r = Response.ok().build();
        } else {
            r = Response.notModified().build();
        }

        return r;
    }

    public Order getOrder(String orderId) {
        System.out.println("----invoking getOrder, Order id is: " + orderId);
        long idNumber = Long.parseLong(orderId);
        Order c = orders.get(idNumber);
        return c;
    }

    

}
