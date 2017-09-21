package com.omn.springdemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.omn.springdemo.service.BusinessService;

@Component("myorg")
public class Organization {

	@Value("${nameOfCompany}")
	private String companyName;
	
	@Value("${startUpYear}")
	private int yearOfIncorporation;
	
	@Value("${postCode}")
	private String postalCode;
	
	@Value("${empCount:22222}")
	private int employeeCount;
	
	@Value("${corporateSlogan:We build the next generation of telecomunications}")
	private String slogan;
	
	private String missionStatement;
	
	@Autowired  
	private Environment env;
	
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
	
	public String corporateSlogan() {
		missionStatement = env.getProperty("statement");  
		return missionStatement + " and also " + slogan;

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

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan");
	}

	

	public String corporateService() {
		return businessService.offService(companyName);
	}

	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan
				+ ", missionStatement=" + missionStatement + ", env=" + env + "]";
	}
}
