package com.assignment.lulu.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.transaction.Transaction;

/**
 * This class is used to create Managed Transaction object This class is used to
 * get the connection object from datasource.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class CustomizedManagedTransaction implements Transaction
{
	/**
	 * It is used to store the database connection
	 */
	private Connection connection;

	/** 
	 * Parameterized Constructor.
	 * @param connection It is used to store the database connection
	 *
	 */
	public CustomizedManagedTransaction ( Connection connection )
	{
		this.connection = connection;
	}

	/**
	 * 
	 * Gets connection.
	 * @return connection
	 */
	public Connection getConnection ( )
	{
		return connection;
	}

	/**
	 * This method is called by ibatis while committing the transaction.
	 * For Managed Transaction, The method will do nothing
	 * @throws SQLException exception.
	 */
	public void commit ( ) throws SQLException
	{
		// Does nothing
	}

	/**
	 * This method is called by ibatis while rollback the transaction.
	 * For Managed Transaction, The method will do nothing
	 * @throws SQLException exception.
	 */
	public void rollback ( ) throws SQLException
	{
		// Does nothing
	}

	/**
	 * This method is called by ibatis while closing the transaction.
	 * @throws SQLException exception.
	 */
	public void close ( ) throws SQLException
	{
		// Does nothing
		try
		{
			if ( connection != null )
			{
				connection.close ();
			}
		}
		catch (SQLException e)
		{
			// Log and ignore. Nothing more that should be done here.
			// log.error(e.getMessage(), e);
		}
	}
}
