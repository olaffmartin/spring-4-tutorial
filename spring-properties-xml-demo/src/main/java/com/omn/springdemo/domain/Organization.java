package com.omn.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.omn.springdemo.service.BusinessService;

public class Organization {

	private String companyName;
	private int yearOfIncorporation;

	@Value("${org.postalCode}")
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;

	public void initialize() {
		System.out.println("initialize called");
	}

	public void destroy() {
		System.out.println("destroy called");
	}

	public void postConstruct() {
		System.out.println("postConstruct");
	}

	public void preDestroy() {
		System.out.println("preDestroy");
	}

	public Organization() {
		System.out.println("default constructor called");
	}

	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("default constructor called");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmployeecount");
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService");
	}

	@Autowired
	public void setSlogan(@Value("${org.slogan}") String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan");
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
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}
}
