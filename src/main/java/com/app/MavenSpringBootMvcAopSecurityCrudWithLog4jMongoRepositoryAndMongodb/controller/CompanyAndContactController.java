package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.controller;

import java.util.ArrayList;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.ICompanyAndContactDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.CompanyDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.ContactDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.ProductDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.repository.ProductRepository;

@Controller
public class CompanyAndContactController {
	
	private Logger logger = Logger.getLogger(CompanyAndContactController.class);
	
	@Autowired
	private ICompanyAndContactDAO companyAndContactDAO;
	
	@Resource
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/welcome-company-contact", method = RequestMethod.GET)
	public ModelAndView showAddCompanyAndContactPage() {
		logger.debug("****Going To Enter On Add Company And Contact Page****");
		logger.debug("");
		logger.debug("");
		ModelAndView model = new ModelAndView();
		model.setViewName("addCompanyAndContact");
		return model;
	}
	
	@RequestMapping(value = "/add-company-contact", method = RequestMethod.POST)
	public ModelAndView callAddCompanyAndContact(@RequestParam("contactPhone") String contactPhone,
			@RequestParam("contactCity") String contactCity,
			@RequestParam("contactCountry") String contactCountry,
			@RequestParam("companyName") String companyName,
			@RequestParam("companyDesc") String companyDesc,
			@ModelAttribute() CompanyDTO companyDTO,
			@ModelAttribute() ContactDTO contactDTO,
			@ModelAttribute() ProductDTO productDTO) throws Exception {
		logger.debug("****Going To Start CallAddCompanyAndContact Method****");
		// for ContactDTO
		contactDTO.setContactPhone(contactPhone);
		contactDTO.setContactCity(contactCity);
		contactDTO.setContactCountry(contactCountry);
		// for CompanyDTO
		companyDTO.setCompanyName(companyName);
		companyDTO.setCompanyDesc(companyDesc);
		companyDTO.setCompanyContact(contactDTO);
		// for product database reference
		ArrayList<ProductDTO> productReference = (ArrayList<ProductDTO>) productRepository.findAll();
		for(int i = 0; i < productReference.size(); i++) {
			companyDTO.setCompanyProduct(productReference.get(i));
		}		
		companyAndContactDAO.addCompanyAndContact(companyDTO);
		if(companyAndContactDAO != null) {
			logger.debug(companyName+" Is Save Successfully");
		}
		else {
			logger.debug("Unable To Save "+companyName);
		}
		logger.debug("****Going To End CallAddCompanyAndContact Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-contact");
	}
	
	@RequestMapping(value = "/fetch-company-contact", method = RequestMethod.GET)
	public ModelAndView callGetAllCompanyAndContact() throws Exception {
		logger.debug("****Going To Start CallGetAllCompanyAndContact Method****");
		ModelAndView model = new ModelAndView("fetch-company-contact");
		ArrayList<CompanyDTO> companyAndContactList = companyAndContactDAO.getAllCompanyAndContact();
		if(companyAndContactList != null && companyAndContactList.size() > 0) {
			model.addObject("companyAndContactList", companyAndContactList);
			logger.debug("You Have Successfully Fetch All Company And Contact List");
		}
		else {
			logger.debug("Unable To Fetch All Company And Contact List");
		}
		logger.debug("****Going To End CallGetAllCompanyAndContact Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/edit-company-contact/{companyId}", method = RequestMethod.GET)
	public ModelAndView callGetCompanyAndContactById(@PathVariable("companyId") String companyId) throws Exception {
		logger.debug("****Going To Start CallGetCompanyAndContactById Method****");
		ModelAndView model = new ModelAndView();
		CompanyDTO editCompanyContact = companyAndContactDAO.getCompanyAndContactById(companyId);
		if(editCompanyContact != null) {
			model.addObject("values", editCompanyContact);
			logger.debug("You Have Successfully Edit Company Id "+companyId);
		}
		else {
			logger.debug("Unable To Edit Company Id "+companyId);
		}
		model.setViewName("updateCompanyAndContact");
		logger.debug("****Going To End CallGetCompanyAndContactById Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@RequestMapping(value = "/update-company-contact", method = RequestMethod.POST)
	public ModelAndView callUpdateCompanyAndContact(@RequestParam("companyId") String companyId,
			@RequestParam("contactPhone") String contactPhone,
			@RequestParam("contactCity") String contactCity,
			@RequestParam("contactCountry") String contactCountry,
			@RequestParam("companyName") String companyName,
			@RequestParam("companyDesc") String companyDesc,
			@ModelAttribute() CompanyDTO companyDTO,
			@ModelAttribute() ContactDTO contactDTO,
			@ModelAttribute() ProductDTO productDTO) throws Exception {
		logger.debug("****Going To Start CallUpdateCompanyAndContact Method****");
		// for ContactDTO
		contactDTO.setContactPhone(contactPhone);
		contactDTO.setContactCity(contactCity);
		contactDTO.setContactCountry(contactCountry);
		// for CompanyDTO
		companyDTO.setCompanyId(companyId);
		companyDTO.setCompanyName(companyName);
		companyDTO.setCompanyDesc(companyDesc);
		companyDTO.setCompanyContact(contactDTO);
		// for product database reference
		ArrayList<ProductDTO> productReference = (ArrayList<ProductDTO>) productRepository.findAll();
		for(int i = 0; i < productReference.size(); i++) {
			companyDTO.setCompanyProduct(productReference.get(i));
		}
		companyAndContactDAO.updateCompanyAndContact(companyDTO);
		if(companyAndContactDAO != null) {
			logger.debug(companyName+" Is Updated Successfully");
		}
		else {
			logger.debug("Unable To Updated "+companyName);
		}
		logger.debug("****Going To End CallUpdateCompanyAndContact Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-contact");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-company-contact/{companyId}", method = RequestMethod.GET)
	public ModelAndView callDeleteCompanyAndContact(@PathVariable("companyId") String companyId) throws Exception {
		logger.debug("****Going To Start CallDeleteCompanyAndContact Method****");
		companyAndContactDAO.deleteCompanyAndContact(companyId);
		if(companyAndContactDAO != null) {
			logger.debug("You Have Successfully Delete Company Id "+companyId);
		}
		else {
			logger.debug("Unable To Delete Company Id "+companyId);
		}
		logger.debug("****Going To End CallDeleteCompanyAndContact Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-contact");
	}	
}
