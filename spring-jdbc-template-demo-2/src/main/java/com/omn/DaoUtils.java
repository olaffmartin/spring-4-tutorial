package com.omn;

import java.util.ArrayList;
import java.util.List;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;

public class DaoUtils {

	public enum Operation {
		CREATE, READ, UPDATE, DELETE, TRUNCATE
	}

	public static void printOrganizations(List<Organization> orgs, Operation op) {
		System.out.println("\n************ printing organizations after " + op + " operation *********");
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}
	
	public static void printOrganization(Organization org, Operation op) {
		System.out.println("\n************ printing organization after invoking" + op + " operation *********\n" + org);
	}

	public static void printSuccessFailure(Operation op, boolean param) {
		if (param)
			System.out.println("\nOperation " + op + " successful");
		else
			System.out.println("\nOperation " + op + " failed");
	}

	public static void createSeedData(OrganizationDao dao) {
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

			System.out.println("Created " + createCount + " organizations");
		}
	}
	
	public static void printOrganizationCount(List<Organization> orgs, Operation op) {
		System.out.println("\n************ Currently we have " + orgs.size() + " organizations after " + op + " operation " + "**************");
	}
}
