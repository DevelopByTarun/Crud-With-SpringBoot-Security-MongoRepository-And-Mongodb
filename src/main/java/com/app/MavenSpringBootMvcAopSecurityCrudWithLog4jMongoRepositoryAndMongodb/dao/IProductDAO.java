package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao;

import java.util.ArrayList;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.ProductDTO;

public interface IProductDAO {
	
	public void addProduct(ProductDTO product) throws Exception;
	
	public void updateProduct(ProductDTO product) throws Exception;
	
	public void deleteProduct(String productId) throws Exception;
	
	public ProductDTO getProductById(String productId) throws Exception;
	
	public ArrayList<ProductDTO> getAllProducts() throws Exception;
}
