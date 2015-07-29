package com.assignment.lulu.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.assignment.lulu.constant.ForexConstant;
import com.assignment.lulu.register.exception.ForexException;

/**
 * 
 * This class is used to create a database session for TREG and WIMS database.
 * It read the configuration file for database related properties
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class SQLSessionFactoryProvider {

	private static SqlSessionFactory mysqlMapper = null;
	/**
	 * To get MySQL Mapper object.
	 * @return SqlSessionFactory
	 * @throws ForexException In case when sqlMap creation fails.
	 */
	public static SqlSessionFactory getSqlSessionFactory ( ) throws ForexException
	{
		if ( mysqlMapper == null )
			createMySQLSessionFactory ();
		return mysqlMapper;
	}
	
	/**
	 * To create MySQL Mapper object if not already created.
	 * @throws ForexException In case of any error.
	 */
	private static synchronized void createMySQLSessionFactory ( ) throws ForexException
	{
		if ( mysqlMapper != null )
			return;
		Reader reader = null;
		try
		{
			try {
				reader = Resources.getResourceAsReader(ForexConstant.IBATIS_CONFIGURATION_FILE);
			} catch (IOException e) {
				throw new ForexException(e, 1000, ForexConstant.IBATIS_CONFIGURATION_FILE+ForexConstant.ERROR_1000);
			}
			//In configuration.xml environment id value is "LuLuOracle"
			mysqlMapper = new SqlSessionFactoryBuilder().build(reader,ForexConstant.DATASOURCE_NAME);
			
		}
		finally{
	    	if( reader != null){
	    		try{
	    			reader.close();
				}
				catch(IOException readerException){
					readerException.printStackTrace();
				}
	    	}
	    }
	}
	
}
