package com.assignment.lulu.register.service;

import com.assignment.lulu.register.dao.CustomerDataDAO;
import com.assignment.lulu.register.dao.CustomerDataDAOImpl;
import com.assignment.lulu.register.exception.ForexException;
import com.assignment.lulu.register.model.CustomerModel;
import com.assignment.lulu.register.model.EmailVO;
import com.assignment.lulu.register.util.EmailUtil;

/**
 * This interface is used to perform operation for Register customer Data. 
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class CustomerDataServiceImpl implements CustomerDataService {

	/**
	 * This method is add Customer Data to db
	 * @param custData Customer Data
	 * @throws ForexException exception may be thrown because of <li>database
	 *             connection error <li>failure of connection with server
	 */
	@Override
	public void addCustomerDataInfo(CustomerModel custData) throws ForexException {
		CustomerDataDAO custDao = new CustomerDataDAOImpl();
		custDao.addCustomerDataInfo(custData);
		EmailVO emailVO = custDao.getEmailDetails();
		String emailBody = EmailUtil.getEmailData(custData);
		System.out.println(emailVO.getUsername() +" : "+emailVO.getPassword());
		try{
		EmailUtil.sendEmail(emailVO, custData.getEmail(), "Registration Success", emailBody);
		}catch(ForexException forexExp){
			//TODO log
			forexExp.printStackTrace();
		}
	}

	/**
	 * This method is to check if the email count.
	 * @param emailID
	 * @return count of emailid in db.
	 * @throws ForexException exception may be thrown because of <li>database
	 *             connection error <li>failure of connection with server
	 */
	@Override
	public Integer checkEmailCount(String emailID) throws ForexException {
		CustomerDataDAO custDao = new CustomerDataDAOImpl();
		return custDao.checkEmailCount(emailID);
	}
	
}
