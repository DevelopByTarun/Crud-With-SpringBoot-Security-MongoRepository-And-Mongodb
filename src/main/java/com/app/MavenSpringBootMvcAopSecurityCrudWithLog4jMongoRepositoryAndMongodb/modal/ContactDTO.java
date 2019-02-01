package com.app.MavenSpringBootMvcAopSecurityCrudWithLog4jMongoRepositoryAndMongodb.modal;

import org.springframework.data.mongodb.core.mapping.Field;

public class ContactDTO {
	
	@Field(value = "contact_phone")
	private String contactPhone;
	
	@Field(value = "contact_city")
	private String contactCity;
	
	@Field(value = "contact_country")
	private String contactCountry;

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the contactCity
	 */
	public String getContactCity() {
		return contactCity;
	}

	/**
	 * @param contactCity the contactCity to set
	 */
	public void setContactCity(String contactCity) {
		this.contactCity = contactCity;
	}

	/**
	 * @return the contactCountry
	 */
	public String getContactCountry() {
		return contactCountry;
	}

	/**
	 * @param contactCountry the contactCountry to set
	 */
	public void setContactCountry(String contactCountry) {
		this.contactCountry = contactCountry;
	}
}
