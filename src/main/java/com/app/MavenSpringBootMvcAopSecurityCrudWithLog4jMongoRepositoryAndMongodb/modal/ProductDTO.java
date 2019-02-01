package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ProductSpringBootMongoDb")
@TypeAlias("ProductDTO")
public class ProductDTO {
	
	@Id
	private String productId;
	
	@Field(value = "product_name")
	@Indexed(name ="productName", unique = true, direction = IndexDirection.ASCENDING)
	private String productName;
	
	@Field(value = "product_desc")
	private String productDesc;

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ "]";
	}
}
