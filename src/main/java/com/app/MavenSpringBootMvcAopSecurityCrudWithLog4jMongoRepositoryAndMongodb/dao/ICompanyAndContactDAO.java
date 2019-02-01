package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao;

import java.util.ArrayList;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.CompanyDTO;

public interface ICompanyAndContactDAO {
	
	public void addCompanyAndContact(CompanyDTO companyandcontact) throws Exception;
	
	public void updateCompanyAndContact(CompanyDTO companyandcontact) throws Exception;
	
	public void deleteCompanyAndContact(String companyId) throws Exception;
	
	public CompanyDTO getCompanyAndContactById(String companyId) throws Exception;
	
	public ArrayList<CompanyDTO> getAllCompanyAndContact() throws Exception;
}
