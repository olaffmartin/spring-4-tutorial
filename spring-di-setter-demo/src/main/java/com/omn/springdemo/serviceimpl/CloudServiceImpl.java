package com.omn.springdemo.serviceimpl;

import java.util.Random;

import com.omn.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offService(String companyName) {
		
		Random random = new Random();
		String service = "\n As an Organization, "+companyName +
				" offers world class Cloud Computing infrastructure."+
				"\n The annual income exceeds "+ random.nextInt(revenue) + " dolars.";
		
		return service;
	}

}
