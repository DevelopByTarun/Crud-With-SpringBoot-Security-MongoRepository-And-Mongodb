package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.CompanyDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.repository.CompanyAndContactRepository;

@Service
public class CompanyAndContactService implements ICompanyAndContactDAO {
	
	@Autowired
	private CompanyAndContactRepository companyAndContactRepository;

	@Override
	public void addCompanyAndContact(CompanyDTO companyandcontact) throws Exception {
		// TODO Auto-generated method stub
		companyAndContactRepository.save(companyandcontact);
	}

	@Override
	public void updateCompanyAndContact(CompanyDTO companyandcontact) throws Exception {
		// TODO Auto-generated method stub
		CompanyDTO getCompanyContact = companyAndContactRepository.findById(companyandcontact.getCompanyId()).get();
		getCompanyContact.setCompanyName(companyandcontact.getCompanyName());
		getCompanyContact.setCompanyDesc(companyandcontact.getCompanyDesc());
		getCompanyContact.setCompanyContact(companyandcontact.getCompanyContact());
		getCompanyContact.setCompanyProduct(companyandcontact.getCompanyProduct());
		companyAndContactRepository.save(getCompanyContact);
	}

	@Override
	public void deleteCompanyAndContact(String companyId) throws Exception {
		// TODO Auto-generated method stub
		companyAndContactRepository.delete(getCompanyAndContactById(companyId));
	}

	@Override
	public CompanyDTO getCompanyAndContactById(String companyId) throws Exception {
		// TODO Auto-generated method stub
		CompanyDTO getCompanyContact = companyAndContactRepository.findById(companyId).get();
		return getCompanyContact;
	}

	@Override
	public ArrayList<CompanyDTO> getAllCompanyAndContact() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<CompanyDTO> companyAndContactList = new ArrayList<CompanyDTO>();
		companyAndContactRepository.findAll().forEach(compcont-> companyAndContactList.add(compcont));
		return companyAndContactList;
	}
}
