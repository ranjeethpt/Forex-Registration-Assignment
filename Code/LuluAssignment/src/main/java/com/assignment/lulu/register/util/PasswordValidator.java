package com.assignment.lulu.register.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for handling Password Validation. 
 * Uses factory pattern.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class PasswordValidator {

	private Pattern pattern;
	private Matcher matcher;
	private static PasswordValidator passwordValidator =null;
	/*
	 * Be between 8 and 20 characters long
	 * Contain at least one digit.
	 * Contain at least one lower case character.
	 * Contain at least one upper case character.
	 * Contain at least on special character from [ @ # $ % ! . ].
	 */
	private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
	
	/**
	 * Private constructor
	 */
	private PasswordValidator() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}
	/**
	 * Create instance if not created. Uses factory design pattern.
	 * @return PasswordValidator instance
	 */
	public static PasswordValidator getInstance(){
		if(passwordValidator == null){
			passwordValidator = new PasswordValidator();
		}
		return passwordValidator;
	}

	/**
	 * Matches the password as per the regex (password policy)
	 * @param password
	 * @return true if valid else false.
	 */
	public boolean validate(String password) {
		matcher = pattern.matcher(password);
		return matcher.matches();

	}
}
