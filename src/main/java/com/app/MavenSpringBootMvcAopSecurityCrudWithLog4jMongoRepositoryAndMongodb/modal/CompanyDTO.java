package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "CompanySpringBootMongoDb")
@TypeAlias("CompanyDTO")
public class CompanyDTO {
	
	@Id
	private String companyId;
	
	@Field(value = "company_name")
	@Indexed(name ="companyName", unique = true, direction = IndexDirection.ASCENDING)
	private String companyName;
	
	@Field(value = "company_desc")
	private String companyDesc;
	
	@Field(value = "company_contact")
	private ContactDTO companyContact;

	@DBRef
	@Field(value = "company_product")
	private ProductDTO companyProduct;

	/**
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyDesc
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}

	/**
	 * @param companyDesc the companyDesc to set
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}

	/**
	 * @return the companyContact
	 */
	public ContactDTO getCompanyContact() {
		return companyContact;
	}

	/**
	 * @param companyContact the companyContact to set
	 */
	public void setCompanyContact(ContactDTO companyContact) {
		this.companyContact = companyContact;
	}

	/**
	 * @return the companyProduct
	 */
	public ProductDTO getCompanyProduct() {
		return companyProduct;
	}

	/**
	 * @param companyProduct the companyProduct to set
	 */
	public void setCompanyProduct(ProductDTO companyProduct) {
		this.companyProduct = companyProduct;
	}
}
