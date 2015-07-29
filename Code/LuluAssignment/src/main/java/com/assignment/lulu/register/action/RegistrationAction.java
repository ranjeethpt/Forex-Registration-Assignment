package com.assignment.lulu.register.action;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.struts2.ServletActionContext;

import com.assignment.lulu.constant.ForexConstant;
import com.assignment.lulu.register.exception.ForexException;
import com.assignment.lulu.register.model.CustomerModel;
import com.assignment.lulu.register.service.CustomerDataService;
import com.assignment.lulu.register.service.CustomerDataServiceImpl;
import com.assignment.lulu.register.util.AESCryptUtil;
import com.assignment.lulu.register.util.DateValidator;
import com.assignment.lulu.register.util.PasswordValidator;
import com.assignment.lulu.register.util.PhoneNumberValidator;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * 
 * An action class for handling register action and form registration.
 * Validate method will validate all form related validation.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class RegistrationAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * For storing Country drop down list
	 */
	private Map<String, String> countryList;
	/**
	 * To get selected value of country.
	 */
	private String country;
	/**
	 * To Store Customer data.
	 */
	private CustomerModel customerInfo;
	
	/**
	 * Getter for Customer Model.
	 * @return CustomerModel
	 */
	public CustomerModel getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * Setter for CustomerModel
	 * @param customerInfo
	 */
	public void setCustomerInfo(CustomerModel customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	/**
	 * Getter for country list.
	 * @return countryList
	 */
	public Map<String, String> getCountryList() {
		return countryList;
	}
	
	/**
	 * Setter for country list
	 * @param countryList
	 */
	public void setCountryList(Map<String, String> countryList) {
		this.countryList = countryList;
	}
	
	/**
	 * Getter for Country
	 * @return country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Setter for country.
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Method called on Form action.
	 */
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getAttribute("edit") != null){
			int editValue = (Integer) request.getAttribute("edit");
			System.out.println("User came for Edit : " + editValue);
		}
		return SUCCESS;
	}
	
	/**
	 * Called when registration form submit.
	 * @return
	 * @throws ForexException
	 */
	public String getDetail() throws ForexException {
		CustomerDataService service = new CustomerDataServiceImpl();
		customerInfo.setCountry(countryList.get(country));
		DateValidator dateValidator = DateValidator.getInstance();
		try {
			customerInfo.setDobDate(dateValidator.getDateFromString(customerInfo.getDateOfBirth()));
		} catch (ParseException e) {
			//Ignore as validation is complete
		}
		customerInfo.setPasswordCrypt(AESCryptUtil.encrypt(customerInfo.getPassword()));
		service.addCustomerDataInfo(customerInfo);
		return SUCCESS;
	}

	/**
	 * Validate method for calling form validation.
	 */
	public void validate(){
		if(customerInfo != null){
			if(customerInfo.getEmail().isEmpty()){
				addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.EMAIL_MAND_MSG));
			}
			else{
				EmailValidator emailFormatValidator = EmailValidator.getInstance();
				if(!emailFormatValidator.isValid(customerInfo.getEmail())){
					addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.EMAIL_FORMAT_MSG));
				}
				else{
					CustomerDataService service = new CustomerDataServiceImpl();
					try {
						if(service.checkEmailCount(customerInfo.getEmail()) > 0){
							addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.EMAIL_DUPLICATE_MSG));
						}
					} catch (Exception e) {
						// TODO Log in logger
						e.printStackTrace();
					}
				}
			}
			if(customerInfo.getPassword().isEmpty()){
				addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.PWD_MAND_MSG));
			}
			else{
				PasswordValidator pwdValidate = PasswordValidator.getInstance();
				if(!pwdValidate.validate(customerInfo.getPassword())){
					addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.PWD_POLICY_MSG));
				}
			}
			if(!customerInfo.getPhone().isEmpty()){
				PhoneNumberValidator phoneNumberValidator = PhoneNumberValidator.getInstance();
				if(!phoneNumberValidator.validate(customerInfo.getPhone(), getCountry())){
					addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.PH_NO_VALID_MSG));
				}
			}
			if(!customerInfo.getDateOfBirth().isEmpty()){
				DateValidator dateValidator = DateValidator.getInstance();
				if(!dateValidator.validate(customerInfo.getDateOfBirth())){
					addFieldError(ForexConstant.ERROR_MSG,getText(ForexConstant.DOB_VALID_MSG));
				}
			}
		}
	}

	/**
	 * For setting country list.
	 */
	@Override
	public void prepare() throws Exception {
		Set<String> set = PhoneNumberUtil.getInstance().getSupportedRegions();
		int setSize = set.size();
		String[] arr = set.toArray(new String[setSize]);
		countryList = new HashMap<String, String>(setSize);
		for (int i = 0; i < set.size(); i++) {
		    Locale locale = new Locale("en", arr[i]);
		    countryList.put(arr[i], locale.getDisplayCountry());
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("countryList", countryList);
	}
}
