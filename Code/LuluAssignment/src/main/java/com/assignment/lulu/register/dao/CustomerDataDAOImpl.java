
package com.assignment.lulu.register.dao;

import org.apache.ibatis.session.SqlSession;

import com.assignment.lulu.constant.ForexConstant;
import com.assignment.lulu.dao.SessionUtil;
import com.assignment.lulu.register.exception.ForexException;
import com.assignment.lulu.register.model.CustomerModel;
import com.assignment.lulu.register.model.EmailVO;

/**
 * This interface is used to perform operation for Customer Register Data.
 * @author ranjeethpt
 * @since 28-07-2015
 */
public class CustomerDataDAOImpl implements CustomerDataDAO {

	/**
	 * This method is add Customer Data to db
	 * @param custData Customer Data
	 * @throws ForexException exception may be thrown because of <li>database
	 *             connection error <li>failure of connection with server
	 */
	@Override
	public void addCustomerDataInfo(CustomerModel custData) throws ForexException {
		SqlSession session = null;
		try{
			session = SessionUtil.getSession();
			session.insert("RegisterMapper.insertCusterData", custData);
			session.commit();
		} catch (Exception e) {
			throw new ForexException(e, 1010, ForexConstant.ERROR_1010);
		} finally {
			if (session != null) {
				session.close();
			}
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
		SqlSession session = null;
		Integer emailcount = 0;
		try{
			session = SessionUtil.getSession();
			emailcount = (Integer) session.selectOne("RegisterMapper.checkEmailCount",emailID);
		} catch (Exception e) {
			throw new ForexException(e, 1020, ForexConstant.ERROR_1020);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emailcount;
	}

	/**
	 * This method is to retrieve email data from db.
	 * @return emailVo
	 * @throws ForexException
	 */
	@Override
	public EmailVO getEmailDetails() throws ForexException {
		SqlSession session = null;
		EmailVO emailVO;
		try{
			session = SessionUtil.getSession();
			emailVO = (EmailVO) session.selectOne("RegisterMapper.getEmailDetails");
		} catch (Exception e) {
			throw new ForexException(e, 1020, ForexConstant.ERROR_1020);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emailVO;
	}
}
