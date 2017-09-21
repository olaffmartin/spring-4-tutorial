package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.springdemo.domain.HumanResourceDept;
import com.omn.springdemo.domain.Organization;

public class DIConstructorApp {

	public static void main(String[] args) {

		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");

		System.out.println(org.corporateSlogan());

		// Print organization details
		 System.out.println(org);
		
		 System.out.println(org.corporateService());
		
		HumanResourceDept hrdept = (HumanResourceDept) ctx.getBean("myhrdept");

		System.out.println(hrdept.hiringStatus(5500));

		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
