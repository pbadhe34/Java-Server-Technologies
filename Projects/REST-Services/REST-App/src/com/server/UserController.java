package com.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/update")
public class UserController {
	
	@RequestMapping(value="/getData",produces="application/xml")
	public User getUser()
	{
		System.out.println("UserController.getUser()");
		User obj = new User();
		obj.setName("Ashok Gupta");
		obj.setNum(12324);
		obj.setSalary(187354.8989);
		return obj;
	}

}
