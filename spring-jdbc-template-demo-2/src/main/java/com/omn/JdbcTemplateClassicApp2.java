package com.omn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;
import com.omn.domain.daoimpl.OrganizationDaoImpl;

public class JdbcTemplateClassicApp2 {
	
	public static void main(String[] args) {
		//creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		
		//create the bean
		OrganizationDao dao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		
		//creating seed data
		DaoUtils.createSeedData(dao);
		
		//List organizations
		List<Organization> orgs = dao.getAllOrganization();
		DaoUtils.printOrganizations(orgs, DaoUtils.Operation.READ);
		
		// create a mew organization record
		
		Organization org1 = new Organization("GE", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org1);
		DaoUtils.printSuccessFailure(DaoUtils.Operation.CREATE, isCreated);
		DaoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.Operation.CREATE);
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.CREATE);
		
		//get single organization
		Organization org2 = dao.getOrganization(1);
		DaoUtils.printOrganization(org2, DaoUtils.Operation.READ);
		
		//update
		org2.setSlogan("Update the slogan");
		DaoUtils.printSuccessFailure(DaoUtils.Operation.UPDATE, dao.update(org2));
		DaoUtils.printOrganization(dao.getOrganization(1), DaoUtils.Operation.UPDATE);
		
		//delete
		DaoUtils.printSuccessFailure(DaoUtils.Operation.DELETE, dao.delete(org2) );
		DaoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.Operation.DELETE);
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.DELETE );
		
		//cleanup
		dao.cleanup();
		DaoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.TRUNCATE);
		
		//close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
