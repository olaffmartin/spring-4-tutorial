package com.omn.domain.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);

	}

	@Override
	public boolean create(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Organization getOrganization(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	@Override
	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

}
