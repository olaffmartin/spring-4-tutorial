package com.omn.springdemo;

import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.springdemo.domain.Organization;
import com.omn.springdemo.domain.promotion.TradeFair;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertiesConfig.class);
		Organization org = (Organization) ctx.getBean("myorg");
		System.out.println(org);
		System.out.println("slogan: " + org.corporateSlogan());
		((AnnotationConfigApplicationContext)ctx).close();

	}

}
