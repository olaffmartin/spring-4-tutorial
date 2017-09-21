package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.springdemo.domain.Organization;

public class CNamespaceApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");
		
		
		// Print organization details
		System.out.println(org);
		
		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
