package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg2");
		
//		org.corporateSlogan();
		
		// Print organization details
		System.out.println(org);
		System.out.println(org2);
		
		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
