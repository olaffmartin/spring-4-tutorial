package com.omn.springdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.omn.springdemo.service.RandomizeRequestScope;
import com.omn.springdemo.service.RandomizeSessionScope;

@Controller
public class ScopeController {
	RandomizeRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizeRequestScope randomizeRequestScope;
	
	@Autowired
	RandomizeSessionScope randomizeSessionScope;
	
	@RequestMapping("/")
	public void getRandom(HttpServletResponse response) throws Exception {
		response.getWriter().write("******************* request scope ************ <br>");
		response.getWriter().write("Old Number: "+randomizeRequestScope.getRandomNumber() + "<br>");
		randomizeRequestScope.generateRandomNumber();
		response.getWriter().write("New Number: "+randomizeRequestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object  reference: "+ randomizeRequestScope + "<br>");
		
		response.getWriter().write("******************* Sessiion scope ************ <br>");
		response.getWriter().write("Old Number: "+randomizeSessionScope.getRandomNumber() + "<br>");
		randomizeSessionScope.generateRandomNumber();
		response.getWriter().write("New Number: "+randomizeSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object  reference: "+ randomizeSessionScope + "<br>");
	}
	

}
