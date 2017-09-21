package com.omn.springdemo;

public class Organization {
	
	private String companyName;
	private int yearOfIncorporation;
	
	
		
	public Organization(String companyName, int yearOfIncorporation) {
		super();
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
	}



	public void corporateSlogan() {
		String slogan = "We build the ultimate driving machines";
		System.out.println(slogan);
		
	}



	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation + "]";
	}
}
