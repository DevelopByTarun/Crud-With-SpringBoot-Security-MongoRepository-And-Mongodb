package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.controller;

import java.util.ArrayList;
import java.util.UUID;
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
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.IProductDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.ProductDTO;

@Controller
public class ProductController {
	
	private Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private IProductDAO productDAO;
	
	@RequestMapping(value = "/welcome-company-product", method = RequestMethod.GET)
	public ModelAndView showAddProductPage() {
		logger.debug("****Going To Enter On Add Product Page****");
		logger.debug("");
		logger.debug("");
		ModelAndView model = new ModelAndView();
		model.setViewName("addProduct");
		return model;
	}
	
	@RequestMapping(value = "/add-company-product", method = RequestMethod.POST)
	public ModelAndView callAddProduct(@RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc,
			@ModelAttribute() ProductDTO productDTO) throws Exception {
		logger.debug("****Going To Start CallAddProduct Method****");
		productDTO.setProductId(UUID.randomUUID().toString());
		productDTO.setProductName(productName);
		productDTO.setProductDesc(productDesc);
		productDAO.addProduct(productDTO);
		if(productDAO != null) {
			logger.debug(productName+" Is Save Successfully");
		}
		else {
			logger.debug("Unable To Save "+productName);
		}
		logger.debug("****Going To End CallAddProduct Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-product");
	}
	
	@RequestMapping(value = "/fetch-company-product", method = RequestMethod.GET)
	public ModelAndView callGetAllProducts() throws Exception {
		logger.debug("****Going To Start CallGetAllProducts Method****");
		ModelAndView model = new ModelAndView("fetch-company-product");
		ArrayList<ProductDTO> productList = productDAO.getAllProducts();
		if(productList != null && productList.size() > 0) {
			model.addObject("productList", productList);
			logger.debug("You Have Successfully Fetch All Product List");
		}
		else {
			logger.debug("Unable To Fetch All product List");
		}
		logger.debug("****Going To End CallGetAllProducts Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/edit-company-product/{productId}", method = RequestMethod.GET)
	public ModelAndView callGetProductById(@PathVariable("productId") String productId) throws Exception {
		logger.debug("****Going To Start CallGetProductById Method****");
		ModelAndView model = new ModelAndView();
		ProductDTO editProduct = productDAO.getProductById(productId);
		if(editProduct != null) {
			model.addObject("values", editProduct);
			logger.debug("You Have Successfully Edit Product Id "+productId);
		}
		else {
			logger.debug("Unable To Edit Product Id "+productId);
		}
		model.setViewName("updateProduct");
		logger.debug("****Going To End CallGetProductById Method****");
		logger.debug("");
		logger.debug("");
		return model;
	}
	
	@RequestMapping(value = "/update-company-product", method = RequestMethod.POST)
	public ModelAndView callUpdateProduct(@RequestParam("productId") String productId,
			@RequestParam("productName") String productName,
			@RequestParam("productDesc") String productDesc,
			@ModelAttribute() ProductDTO productDTO) throws Exception {
		logger.debug("****Going To Start CallUpdateProduct Method****");
		productDTO.setProductId(productId);
		productDTO.setProductName(productName);
		productDTO.setProductDesc(productDesc);
		productDAO.updateProduct(productDTO);
		if(productDAO != null) {
			logger.debug(productName+" Is Updated Successfully");
		}
		else {
			logger.debug("Unable To Updated "+productName);
		}
		logger.debug("****Going To End CallUpdateProduct Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-product");
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/delete-company-product/{productId}", method = RequestMethod.GET)
	public ModelAndView callDeleteProduct(@PathVariable("productId") String productId) throws Exception {
		logger.debug("****Going To Start CallDeleteProduct Method****");
		productDAO.deleteProduct(productId);
		if(productDAO != null) {
			logger.debug("You Have Successfully Delete Product Id "+productId);
		}
		else {
			logger.debug("Unable To Delete Product Id "+productId);
		}
		logger.debug("****Going To End CallDeleteProduct Method****");
		logger.debug("");
		logger.debug("");
		return new ModelAndView("redirect:/fetch-company-product");
	}		
}
