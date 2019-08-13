package com.service;

import javax.ws.rs.core.Response;
import org.springframework.security.access.annotation.Secured;


public interface CustomerServiceSecured {
    
   // @Secured({"ROLE_CUSTOMER", "ROLE_ADMIN" })
    Customer getCustomer(String id);

    @Secured("ROLE_ADMIN")
    Response updateCustomer(Long id, Customer customer);
    
    @Secured("ROLE_ADMIN")
    Response addCustomer(Customer customer);

    @Secured("ROLE_ADMIN")
    Response deleteCustomer(String id);

    @Secured({"ROLE_CUSTOMER", "ROLE_ADMIN" })
    Order getOrder(String orderId);

}
