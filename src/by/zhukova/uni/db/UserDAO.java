package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.entity.User;

public class UserDAO extends AbstractDAO {

	static Logger logger = Logger.getLogger(UserDAO.class);
	private final String SELECT_ALL = "SELECT * FROM users";
	private final String SELECT_BY_ID = "SELECT * FROM users WHERE id=?";
	private final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username=?"; // specific User method
	private final String DELETE = "DELETE FROM users WHERE id=?";
	private final String CREATE = "INSERT INTO users (id, username, password, user_type) VALUES (?, ?, ?, ?)";
	private final String UPDATE = "UPDATE users SET  username=?, password=?, user_type=? WHERE id=?";

	public UserDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		try {
			PreparedStatement pst = connection.prepareStatement(SELECT_ALL);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setUserType(res.getString(4));

				list.add(user);
			}
			

		} catch (SQLException e) {
			logger.error(e);
		} finally {
			close(pst);
		}
		return list;
	}

	@Override
	public User findEntityById(int id) {
		
		PreparedStatement pst;
		User user = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setUserType(res.getString(4));
			}
			
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			close(pst);
		}

		return user;
	}
	
	public User findUserByUsername(String username) {
		
		PreparedStatement pst;
		User user = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_USERNAME);
			pst.setString(1, username);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setUserType(res.getString(4));
			}
			
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			close(pst);
		}

		return user;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement pst;
		boolean result;
		try {
			pst = connection.prepareStatement(DELETE);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		} finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) {
		boolean result;
		int id = entity.getId();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(DELETE);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		} finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean create(Entity entity) {
		boolean result;
		PreparedStatement pst;
		User user = (User) entity;
		try {
			pst = connection.prepareStatement(CREATE);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getUserType());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		} finally {
			close(pst);	
		}
		return result;
	}

	@Override
	public boolean update(Entity entity) {
		boolean result;
		User user = (User) entity;
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserType());
			pst.setInt(4, user.getId());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			

		} catch (SQLException e) {
			logger.error(e);
			result = false;
		} finally {
			close(pst);
		}
		return result;
	}

}
