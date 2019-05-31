package com.project.orderMgmt.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.orderMgmt.Model.Login;
import com.project.orderMgmt.Service.LoginService;

@RestController
@RequestMapping(value="/login", produces="application/json")
public class loginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/saveCustomerPassword", method=RequestMethod.POST, consumes="application/json")
	public String savePassword(@RequestBody Login login)
	{
		loginService.savePassword(login);
		return "Customer Saved";
	}
	
	@RequestMapping(value="/verify", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public String verify(@RequestBody Login login)
	{
		System.err.println("loginController.verify()---->"+login);
		String res=loginService.verify(login);
		return res;
	}

}
