package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.UserDAO;
import by.zhukova.uni.entity.User;

public class LoginLogic {

	static Logger logger = Logger.getLogger(LoginLogic.class);

	public static boolean checkLogin(String enterLogin, String enterPass) {
		boolean result = false;
		Connection con = ConnectionPool.getConnection();
		UserDAO userDao = new UserDAO(con);
		enterLogin = enterLogin.toLowerCase();
		User user = userDao.findUserByUsername(enterLogin);
		if ((user != null)
				&& (user.getPassword()
						.equals(MD5Digest.getMD5String(enterPass)))) {
			result = true;
		} else {
			result = false;
		}

		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;

	}

	public static boolean isAdmin(String username) {
		boolean result;
		Connection con = ConnectionPool.getConnection();
		UserDAO userDao = new UserDAO(con);
		User user = userDao.findUserByUsername(username);
		String type = user.getUserType();
		if (type.equals("admin")) {
			result = true;
		} else {
			result = false;
		}
		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}

}
