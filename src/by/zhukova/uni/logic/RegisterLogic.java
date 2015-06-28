package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.UserDAO;
import by.zhukova.uni.entity.User;

public class RegisterLogic {
	
	static Logger logger = Logger.getLogger(RegisterLogic.class);
	
	public static boolean checkLoginAvailable(String login) {
		boolean result = false;
		Connection con = ConnectionPool.getConnection();
		UserDAO userDao = new UserDAO(con);
		login = login.toLowerCase();
		User user = userDao.findUserByUsername(login);
		
		if (user==null) {
			result = true;
		}	
		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	
	public static boolean addNewUser(String login, String password) {
		boolean result = false;
		Connection con = ConnectionPool.getConnection();
		UserDAO userDao = new UserDAO(con);
		User user = new User();
		user.setUsername(login);
		user.setPassword(MD5Digest.getMD5String(password));
		result = userDao.create(user);
		
		return result;
		
	}

}
