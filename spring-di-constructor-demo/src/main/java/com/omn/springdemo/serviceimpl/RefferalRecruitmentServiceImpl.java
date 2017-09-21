package com.omn.springdemo.serviceimpl;

import java.util.Random;

import com.omn.springdemo.service.RecruitmentService;

public class RefferalRecruitmentServiceImpl implements RecruitmentService {

	@Override
	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n " + companyName + "'s " + departmentName + " hired "
				+ random.nextInt(numberOfRecruitments) + " employees "
				+ "which were referred to the company by employees.";
		return hiringFacts;
	}

}
