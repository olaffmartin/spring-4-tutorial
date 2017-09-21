package com.omn;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;

@Service
public class DaoUtils {

	public enum Operation {
		CREATE, READ, UPDATE, DELETE, TRUNCATE
	}
	private static Logger LOGGER = LoggerFactory.getLogger("Loggint Tester");

	public void printOrganizations(List<Organization> orgs, Operation op) {
		LOGGER.info("\n************ printing organizations after " + op + " operation *********");
		for (Organization org : orgs) {
			LOGGER.info(org.toString());
		}
	}
	
	public void printOrganization(Organization org, Operation op) {
		LOGGER.info("\n************ printing organization after invoking" + op + " operation *********\n" + org);
	}

	public void printSuccessFailure(Operation op, boolean param) {
		if (param)
			LOGGER.info("\nOperation " + op + " successful");
		else
			LOGGER.info("\nOperation " + op + " failed");
	}

	public void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon", 1994, "6566", 8765, "Work hard, have fun, make history");
		Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");
		Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");

		List<Organization> orgs = new ArrayList<Organization>();
		orgs.add(0, org1);
		orgs.add(1, org2);
		orgs.add(2, org3);
		int createCount = 0;
		for (Organization org : orgs) {
			boolean isCreated = dao.create(org);
			if (isCreated) {
				createCount++;
			}

			LOGGER.info("Created " + createCount + " organizations");
		}
	}
	
	public void printOrganizationCount(List<Organization> orgs, Operation op) {
		LOGGER.info("\n************ Currently we have " + orgs.size() + " organizations after " + op + " operation " + "**************");
	}
}
