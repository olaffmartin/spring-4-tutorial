package com.omn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;
import com.omn.domain.daoimpl.OrganizationDaoImpl;

@Component
public class LoggingApp {

	@Autowired
	private OrganizationDao dao;

	@Autowired
	private DaoUtils daoUtils;

	public void actionPerform() {
		// creating seed data
		daoUtils.createSeedData(dao);

		// List organizations
		List<Organization> orgs = dao.getAllOrganization();
		daoUtils.printOrganizations(orgs, DaoUtils.Operation.READ);

		// create a mew organization record

		Organization org1 = new Organization("GE", 1978, "98989", 5776, "Imagination at work");
		boolean isCreated = dao.create(org1);
		daoUtils.printSuccessFailure(DaoUtils.Operation.CREATE, isCreated);
		daoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.Operation.CREATE);
		daoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.CREATE);

		// get single organization
		Organization org2 = dao.getOrganization(1);
		daoUtils.printOrganization(org2, DaoUtils.Operation.READ);

		// update
		org2.setSlogan("Update the slogan");
		daoUtils.printSuccessFailure(DaoUtils.Operation.UPDATE, dao.update(org2));
		daoUtils.printOrganization(dao.getOrganization(1), DaoUtils.Operation.UPDATE);

		// delete
		daoUtils.printSuccessFailure(DaoUtils.Operation.DELETE, dao.delete(org2));
		daoUtils.printOrganizations(dao.getAllOrganization(), DaoUtils.Operation.DELETE);
		daoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.DELETE);

		// cleanup
		dao.cleanup();
		daoUtils.printOrganizationCount(dao.getAllOrganization(), DaoUtils.Operation.TRUNCATE);
	}

	public static void main(String[] args) {
		// creating the application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		LoggingApp mainApp = (LoggingApp)ctx.getBean(LoggingApp.class);
		mainApp.actionPerform();
		
		// close the application context
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
