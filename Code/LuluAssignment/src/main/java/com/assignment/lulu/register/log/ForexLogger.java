package com.assignment.lulu.register.log;


import org.apache.log4j.Logger;

/**
 * This class contain method to retrieve logger object.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class ForexLogger{

	/**
	 * It contain the message logger object
	 */
	private static Logger messageLogger = Logger.getRootLogger();
	/**
	 * Logger will log to ErrorCode.log
	 */
	private static Logger errorCodeLogger = Logger.getLogger("AppLogging");
	private ForexLogger(){
		// private constructor
	}

	/**
	 * 
	 * This method retrieve the logger object for common message.
	 * @return Message Logger object
	 */
	public static Logger getMessageLogger(){
		return messageLogger;
	}
	/**
	 * 
	 * This method retrieve the logger object for error Code Logger.
	 * @return Error code Logger object
	 */
	public static Logger getErrorCodeLogger(){
		return errorCodeLogger;
	}
}
