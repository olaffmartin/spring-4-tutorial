package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.springdemo.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");
		Organization org2 = (Organization) ctx.getBean("myorg");
		org2.setPostalCode("98999");
		
		
		System.out.println(org.corporateSlogan());
		
		// Print organization details
		System.out.println(org);
		System.out.println(org2);
		
		if(org == org2) {
			System.out.println("Singleton socpe test org and org2 point to same instance");			
		}else {
			System.out.println("Both org and org2 are separate instance");
		}
		
		System.out.println(org.corporateService());
		
		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
