package com.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.server.BackendService;
import com.server.MyModel;
import com.server.MyResource;

 
@RunWith(MockitoJUnitRunner.class)
public class InMemoryRestWithMockitoTest {

     
     

    @InjectMocks
    public static MyResource sut = new MyResource();
    public static InMemoryRestServer server;

    @Mock
    private static BackendService backendServiceMock;

    @BeforeClass
    public static void beforeClass() throws Exception {
        server = InMemoryRestServer.create(sut);
       // sut.setBackendService(backendServiceMock);
    }

    @AfterClass
    public static void afterClass() throws Exception {
        server.close();
    }

    @Test
    public void postWithoutMocking() throws Exception {

        Response response = server.newRequest("/upload").request().buildPost(Entity.text("42")).invoke();
        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }

    @Test
    public void postWithMocking() throws Exception {

        when(backendServiceMock.getMyModel(42)).thenReturn(new MyModel(42));

        Response response = server.newRequest("/upload").request().buildPost(Entity.text("42")).invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        MyModel myModel = response.readEntity(MyModel.class);
        assertEquals(42, myModel.getResult());
    }
}
