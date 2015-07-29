package com.assignment.lulu.register.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * Class for handling Phone number Validation based on country selected. 
 * Uses google's libphonenumber library.
 * Uses factory pattern.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class PhoneNumberValidator {

	private static PhoneNumberValidator phoneNumberValidator = null;
	private static PhoneNumberUtil phoneNumberUtil=null;
	
	/**
	 * Private constructor.
	 */
	private PhoneNumberValidator() {
		phoneNumberUtil = PhoneNumberUtil.getInstance();
	}
	
	/**
	 * Create instance if not created. Uses factory design pattern.
	 * @return PhoneNumberValidator instance
	 */
	public static PhoneNumberValidator getInstance(){
		if(phoneNumberValidator == null){
			phoneNumberValidator = new PhoneNumberValidator();
		}
		return phoneNumberValidator;
	}
	/**
	 * Matches the password as per the phone number utility.
	 * @param password
	 * @return true if valid else false.
	 */
	public boolean validate(String phoneNo,String country){
		boolean isValidPhone = false;
		Phonenumber.PhoneNumber phoneNumber;
		try {
			phoneNumber = phoneNumberUtil.parse(phoneNo, "");
		} catch (NumberParseException e) {
			return isValidPhone;
		}
		if(phoneNumberUtil.getRegionCodeForNumber(phoneNumber).equals(country)){
			isValidPhone = true;
		}
		return isValidPhone;
	}
}
