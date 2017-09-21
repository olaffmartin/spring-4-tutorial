package com.omn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge1 {

	public static void main(String[] args) {
		// create ApplicationCOntext container
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/beans-challenge.xml");
		
		// create spring beans
		City city = (City) ctx.getBean("myCity");
		
		System.out.println("City name "+city.cityName());
		
		// Close application context
		
		((FileSystemXmlApplicationContext) ctx).close();

	}

}
