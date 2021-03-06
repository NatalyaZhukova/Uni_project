package by.zhukova.uni.logic;

import java.sql.Connection;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.UserDAO;
import by.zhukova.uni.entity.User;
import by.zhukova.uni.exception.DaoException;

/**
 * The Class LoginLogic contains the methods which are used in login process.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class LoginLogic {

	static Logger logger = Logger.getLogger(LoginLogic.class);

	/**
	 * The method checks if the user with given username and password exists
	 * 
	 * @param enterLogin
	 *            username
	 * @param enterPass
	 *            password
	 * @return true, if it exists
	 */
	public static boolean checkLogin(String enterLogin, String enterPass) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		UserDAO userDao = new UserDAO(con);
		enterLogin = enterLogin.toLowerCase();
		User user = null;
		try {
			user = userDao.findUserByUsername(enterLogin);
		} catch (DaoException e) {
			logger.error(e);
		}
		if ((user != null) && (user.getPassword().equals(StringUtils.getMD5String(enterPass)))) {
			result = true;
		} else {
			result = false;
		}

		pool.returnConnection(con);

		return result;

	}

	/**
	 * The method checks if the user with given username is administrator.
	 * 
	 * @param username
	 *            the username
	 * @return true if type of user is administrator
	 */
	public static boolean isAdmin(String username) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		UserDAO userDao = new UserDAO(con);
		User user = null;
		try {
			user = userDao.findUserByUsername(username);
		} catch (DaoException e1) {
			logger.error(e1);
		}
		String type = user.getUserType();
		if (type.equals("admin")) {
			result = true;
		}
		pool.returnConnection(con);
		return result;
	}

}
