package com.omn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;
import com.omn.domain.daoimpl.OrganizationDaoImpl;

public class JdbcTemplateClassicApp1 {
	
	public static void main(String[] args) {
		//creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgs = dao.getAllOrganization();
		
		for (Organization org : orgs) {
			System.out.println(org);
		}
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
