package com.assignment.lulu.register.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class for validating Date format.
 * @author ranjeethpt
 * @since 28-07-2015
 *
 */
public class DateValidator {

	private static DateValidator dateValidatorInstance = null;
	private static String dateFormat = "MM/dd/yyyy";
	private DateValidator(){
		
	}
	/**
	 * Singleton pattern.
	 * @return DateValidator instance
	 */
	public static DateValidator getInstance(){
		if(dateValidatorInstance == null){
			dateValidatorInstance = new DateValidator();
		}
		return dateValidatorInstance;
	}
	
	/**
	 * To convert date string as per "MM/dd/yyyy" format.
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public Date getDateFromString(String dateStr) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		 sdf.setLenient(false);
		 return sdf.parse(dateStr);
	}
	
	/**
	 * To validate if the input is as per "MM/dd/yyyy" date format
	 * @param date
	 * @return true if date as per the format else false.
	 */
	public boolean validate(String date){
		boolean isValidDate = false;
		if(date == null){
			return isValidDate;
		}
 		try {
 			//if not valid, it will throw ParseException
 			getDateFromString(date);
			isValidDate = true;
		} catch (ParseException e) { 
			// ignore
		}
		return isValidDate;
	}
}
