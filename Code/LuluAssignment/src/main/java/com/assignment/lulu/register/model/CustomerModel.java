package com.assignment.lulu.register.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Customer Model to save Customer registration info.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class CustomerModel implements Serializable {

	private int id;
	private String custName;
	private String address;
	private String email;
	private String country;
	private String phone;
	private String dateOfBirth;
	private String password;
	private Date dobDate;
	private String passwordCrypt;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dobDate
	 */
	public Date getDobDate() {
		return dobDate;
	}
	/**
	 * @param dobDate the dobDate to set
	 */
	public void setDobDate(Date dobDate) {
		this.dobDate = dobDate;
	}
	/**
	 * @return the passwordCrypt
	 */
	public String getPasswordCrypt() {
		return passwordCrypt;
	}
	/**
	 * @param passwordCrypt the passwordCrypt to set
	 */
	public void setPasswordCrypt(String passwordCrypt) {
		this.passwordCrypt = passwordCrypt;
	}
	
}
