package com.assignment.lulu.constant;

/**
 * To store all Application related constants.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class ForexConstant {
	/**
	 * To Store Ibatic configuration file string
	 */
	public static final String IBATIS_CONFIGURATION_FILE = "Configuration.xml";
	/**
	 * To store datasource name
	 */
	public static final String DATASOURCE_NAME = "LuLuMysqlDS";
	/**
	 * To store error message, used in front end jsp as placeholder for field error.
	 */
	public static final String ERROR_MSG = "error.msg";
	/**
	 * Email mandatory message, to pickup from property file.
	 */
	public static final String EMAIL_MAND_MSG = "email.mandatory.message";
	/**
	 * Email format message, to pickup from property file.
	 */
	public static final String EMAIL_FORMAT_MSG = "email.format.message";
	/**
	 * Email duplicate message, to pickup from property file.
	 */
	public static final String EMAIL_DUPLICATE_MSG = "email.duplicate.message";
	/**
	 * Password mandatory message, to pickup from property file.
	 */
	public static final String PWD_MAND_MSG = "password.mandatory.message";
	/**
	 * Password policy message, to pickup from property file.
	 */
	public static final String PWD_POLICY_MSG = "password.policy.mismatch.message";
	/**
	 * Phone number valid message, to pickup from property file.
	 */
	public static final String PH_NO_VALID_MSG = "phonenumber.valid.message";
	/**
	 * Date of birth message, to pickup from property file.
	 */
	public static final String DOB_VALID_MSG = "dob.valid.message";
	
	
	
	
	/**
	 * Error Code Section
	 *
	 */
	//TODO Should be in property file
	public static final String ERROR_1000 = " file not found";
	public static final String ERROR_1010 = "Error inserting to DB";
	public static final String ERROR_1020 = "Error selecting data from DB";
	public static final String ERROR_1030 = "Error in decrypting password";
	public static final String ERROR_1031 = "Error in encrypting password";
	public static final String ERROR_1040 = "Error in sending email";

}
