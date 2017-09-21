package com.omn.domain.dao;

import java.util.List;

import javax.sql.DataSource;

import com.omn.domain.Organization;

public interface OrganizationDao {
	
	// set the datasource that will be required to create the connection to the database
	public void setDataSource(DataSource ds);
	
	// Create a record in the organization table
	public boolean create(Organization org);
	
	//retrieve a single Organization
	public Organization getOrganization(Integer id);
	
	//retrieve all Organizations
	public List<Organization> getAllOrganization();
	
	// delete a record in the organization table
	public boolean delete(Organization org);
	
	// update a record in the organization table
	public boolean update(Organization org);
	
	public void cleanup();
}
