package com.rest.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;
 

public class UserRestServiceApplication  extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	 
	public UserRestServiceApplication() {
		singletons.add(new UserRestService());
	}
 
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

}
