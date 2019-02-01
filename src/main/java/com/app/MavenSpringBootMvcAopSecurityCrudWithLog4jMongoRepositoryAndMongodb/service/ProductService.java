package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.dao.IProductDAO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal.ProductDTO;
import com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.repository.ProductRepository;

@Service
public class ProductService implements IProductDAO {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(ProductDTO product) throws Exception {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDTO product) throws Exception {
		// TODO Auto-generated method stub
		ProductDTO getProduct = productRepository.findById(product.getProductId()).get();
		getProduct.setProductName(product.getProductName());
		getProduct.setProductDesc(product.getProductDesc());
		productRepository.save(getProduct);
	}

	@Override
	public void deleteProduct(String productId) throws Exception {
		// TODO Auto-generated method stub
		productRepository.delete(getProductById(productId));
	}

	@Override
	public ProductDTO getProductById(String productId) throws Exception {
		// TODO Auto-generated method stub
		ProductDTO getProduct = productRepository.findById(productId).get();
		return getProduct;
	}

	@Override
	public ArrayList<ProductDTO> getAllProducts() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductDTO> productList = new ArrayList<ProductDTO>();
		productRepository.findAll().forEach(proud-> productList.add(proud));
		return productList;
	}
}
