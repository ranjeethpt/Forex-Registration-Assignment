package com.assignment.lulu.register.exception;

/**
 * To handle all exception
 * @author ranjeethpt
 * @since 29-07-2015
 */
public class ForexException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6752795250942687456L;
	
	/**
	 * Store Error Code
	 */
	private int errorCode;

	/**
	 * It is used to store the message.
	 */
	private String message;
	
	/**
	 * All exception need to be using ForexException.
	 * The metho will channel exception via one framework. The method can be then used to log to file, or log to db or
	 *  attach email functionality to raise an automatic ticket.
	 * @param cause Cause of Exception
	 * @param errorCode Error Code
	 * @param message Error Message
	 */
	public ForexException(Throwable cause,int errorCode,String message) {
		// TODO This need to moved to log file, db, or other means of information.
		System.out.println("Exception Reported : " + errorCode + " : " +message);
		cause.printStackTrace();
		this.errorCode=errorCode;
		this.message=message;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
