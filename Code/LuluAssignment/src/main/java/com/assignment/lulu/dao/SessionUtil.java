package com.assignment.lulu.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.assignment.lulu.dao.SQLSessionFactoryProvider;
import com.assignment.lulu.register.exception.ForexException;

/**
 * Class contains method that creates and returns SqlSession object needed by methods of different DAO classes.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class SessionUtil{
	
	/**
	 * Method creating and returning SqlSession object needed by other methods of this class.	 
	 * @return SqlSession object
	 * @throws ForexException
	 *             exception may be thrown because of <li>failure to open SqlSession
	 */
	public static SqlSession getSession() throws ForexException{		
		SqlSessionFactory sqlMapper = SQLSessionFactoryProvider.getSqlSessionFactory();
		return sqlMapper.openSession();
	}
}
