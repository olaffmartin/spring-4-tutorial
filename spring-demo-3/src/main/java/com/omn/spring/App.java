package com.omn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// create ApplicationCOntext container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-challenge.xml");
		
		// create spring beans
		City city = (City) ctx.getBean("myCity");
		
		System.out.println("City name "+city.cityName());
		
		// Close application context
		
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
