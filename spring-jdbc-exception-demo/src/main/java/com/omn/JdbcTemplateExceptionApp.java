package com.omn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;
import com.omn.domain.daoimpl.OrganizationDaoImpl;

public class JdbcTemplateExceptionApp {
	
	public static void main(String[] args) {
		//creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgs = null;
		try {
			orgs = dao.getAllOrganization();
		} catch (BadSqlGrammarException e) {
			System.out.println("SUB Exception message: " + e.getMessage());
			System.out.println("SUB Exception class: " + e.getClass());
		}catch (DataAccessException e) {
			System.out.println("Exception message: " + e.getMessage());
			System.out.println("Exception class: " + e.getClass());
		}
		
		for (Organization org : orgs) {
			System.out.println(org);
		}
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
