package com.omn.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.springdemo.domain.Organization;
import com.omn.springdemo.domain.dao.OrganizationDao;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationDao organizationDao;

	public List<Organization> getOrgList() {
		List<Organization> orgList = organizationDao.getAllOrganization();
		return orgList;
	}

}
