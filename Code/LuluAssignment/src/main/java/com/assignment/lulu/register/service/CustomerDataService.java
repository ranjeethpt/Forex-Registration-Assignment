package com.assignment.lulu.register.service;

import com.assignment.lulu.register.exception.ForexException;
import com.assignment.lulu.register.model.CustomerModel;

/**
 * This interface is used to perform operation for Register customer Data. 
 * @author ranjeethpt
 * @since 28-07-2015
 */
public interface CustomerDataService {
	/**
	 * This method is add Customer Data to db
	 * @param custData Customer Data
	 * @throws ForexException exception may be thrown because of <li>database
	 *             connection error <li>failure of connection with server
	 */
	public void addCustomerDataInfo (CustomerModel custData) throws ForexException;
	/**
	 * This method is to check if the email count.
	 * @param emailID
	 * @return count of emailid in db.
	 * @throws ForexException exception may be thrown because of <li>database
	 *             connection error <li>failure of connection with server
	 */
	public Integer checkEmailCount (String emailID) throws ForexException;
	
	}
