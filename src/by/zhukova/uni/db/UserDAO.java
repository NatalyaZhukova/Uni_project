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

	public UserDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		String query = "SELECT * FROM users";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				User user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setUserType(res.getString(4));

				list.add(user);
			}
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
		}
		return list;
	}

	@Override
	public User findEntityById(int id) {
		String query = "SELECT * FROM users WHERE id=?";
		PreparedStatement pst;
		User user = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				user = new User();
				user.setId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setUserType(res.getString(4));
			}
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
		}

		return user;
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM users WHERE id=?";
		PreparedStatement pst;
		boolean result;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) {
		boolean result;
		int id = entity.getId();
		String query = "DELETE FROM users WHERE id=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean create(Entity entity) {
		boolean result;
		String query = "INSERT INTO users (id, username, password, user_type) VALUES (?, ?, ?, ?)";
		PreparedStatement pst;
		User user = (User) entity;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, user.getId());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getUserType());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(Entity entity) {
		boolean result;
		User user = (User) entity;
		String query = "UPDATE users SET  username=?, password=?, user_type=? WHERE id=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserType());
			pst.setInt(4, user.getId());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		return result;
	}

}
