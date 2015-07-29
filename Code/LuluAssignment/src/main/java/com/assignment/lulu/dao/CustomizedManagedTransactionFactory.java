package com.assignment.lulu.dao;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

/**
 * This class is used to create Managed Transaction Factory object. This class
 * is used to create the new transaction object.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class CustomizedManagedTransactionFactory implements TransactionFactory
{
	/**
	 * This method is used to set transaction properties.
	 * @param properties properties.
	 */
	public void setProperties ( Properties properties )
	{
		// does nothing
	}

	/**
	 * This method is used to create the transaction object.
	 * @param conn The connection object retrieved from the datasource.
	 * @param autoCommit It is used to autocommit the transaction.
	 * @return Transaction Transaction object
	 */
	public Transaction newTransaction ( Connection conn , boolean autoCommit )
	{
		return new CustomizedManagedTransaction ( conn );
	}
}
