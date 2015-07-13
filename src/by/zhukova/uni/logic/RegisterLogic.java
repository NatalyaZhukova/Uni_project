package by.zhukova.uni.logic;

import java.sql.Connection;


import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.UserDAO;
import by.zhukova.uni.entity.User;
import by.zhukova.uni.exception.DaoException;
/** 
* The Class RegisterLogic contains the methods which are used in register process.
*
* @author Natallya Zhukova
* @since 1.0
*/
public class RegisterLogic {
	
	static Logger logger = Logger.getLogger(RegisterLogic.class);
	/** 
	* The method checks if login is available
	* @param login
	* @return true, if it's available
	*/
	public static boolean checkLoginAvailable(String login) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		UserDAO userDao = new UserDAO(con);
		login = login.toLowerCase();
		User user=null;
		try {
			user = userDao.findUserByUsername(login);
		} catch (DaoException e) {
			logger.error(e);
		}
		
		if (user==null) {
			result = true;
		}	
		
		pool.returnConnection(con);
		return result;
	}
	/** 
	* The method adds new user to database
	* @param login, password
	* @return true, if successful
	*/
	public static boolean addNewUser(String login, String password) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		UserDAO userDao = new UserDAO(con);
		User user = new User();
		user.setUsername(login);
		user.setPassword(StringUtils.getMD5String(password));
		try {
			result = userDao.create(user);
		} catch (DaoException e) {
			logger.error(e);
		}
		
		
		pool.returnConnection(con);
		return result;
		
	}

}
