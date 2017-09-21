package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCApp1 {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		
		// create the beans
		Organization org = (Organization) ctx.getBean("myorg");
		
		org.corporateSlogan();
		
		// Close the aplication context (container)
		((FileSystemXmlApplicationContext) ctx).close();

	}

}
