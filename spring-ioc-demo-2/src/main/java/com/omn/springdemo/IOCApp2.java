package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCApp2 {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");
		
		org.corporateSlogan();
		
		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
