package com.omn.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.springdemo.domain.Organization;
import com.omn.springdemo.domain.promotion.TradeFair;

public class AutowiredAnnotationApp {

	public static void main(String[] args) {
		
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		TradeFair tradeFair = (TradeFair) ctx.getBean("myfair");
		System.out.println(tradeFair.specialPromotionalPricing());
		
	
		// Close the aplication context (container)
		((ClassPathXmlApplicationContext) ctx).close();

	}

}
