package com.omn.domain.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.omn.domain.Organization;
import com.omn.domain.dao.OrganizationDao;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

	private NamedParameterJdbcTemplate namedParamJdbcTemplate;
	
	@Override
	@Autowired
	public void setDataSource(DataSource ds) {
		namedParamJdbcTemplate = new NamedParameterJdbcTemplate(ds);

	}

	@Override
	public boolean create(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		
		String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) "+
				"VALUES(:companyName, :yearOfIncorporation, :postalCode, :employeeCount, :slogan )";
		
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public Organization getOrganization(Integer id) {
		SqlParameterSource params = new MapSqlParameterSource("ID", id);
		String sqlQuery = "SELECT * FROM organization where id = :ID";
		
		Organization org = namedParamJdbcTemplate.queryForObject(sqlQuery, params, new OrganizationRowMapper());
		return org;
	}

	@Override
	public List<Organization> getAllOrganization() {
		String sqlQuery = "SELECT * FROM organization";
		List<Organization> orgList = namedParamJdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	@Override
	public boolean delete(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "DELETE FROM organization WHERE id = :id";
		
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public boolean update(Organization org) {
		SqlParameterSource beanParams = new BeanPropertySqlParameterSource(org);
		String sqlQuery = "UPDATE organization SET slogan = :slogan WHERE id = :id";
		return namedParamJdbcTemplate.update(sqlQuery, beanParams) == 1;
	}

	@Override
	public void cleanup() {
		String sqlQuery = "TRUNCATE TABLE organization ";
		namedParamJdbcTemplate.getJdbcOperations().execute(sqlQuery);

	}

}
