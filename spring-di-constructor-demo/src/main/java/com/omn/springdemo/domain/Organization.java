package com.omn.springdemo.domain;

import com.omn.springdemo.service.BusinessService;

public class Organization {

	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;

	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String corporateSlogan() {
		return slogan;

	}

	public String corporateService() {
		return businessService.offService(companyName);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}
}
