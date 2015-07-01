package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.entity.User;
import by.zhukova.uni.exception.DaoException;

public class UserDAO extends AbstractDAO {

	
	private final String SELECT_ALL = "SELECT * FROM users";
	private final String SELECT_BY_ID = "SELECT * FROM users WHERE id=?";
	private final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username=?"; // specific User method
	private final String DELETE = "DELETE FROM users WHERE id=?";
	private final String CREATE = "INSERT INTO users (username, password, user_type) VALUES (?, ?, ?)";
	private final String UPDATE = "UPDATE users SET  username=?, password=?, user_type=? WHERE id=?";

	public UserDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<User> findAll() throws DaoException {
		List<User> list = new ArrayList<User>();
		PreparedStatement pst = null;
		try {
			 pst = connection.prepareStatement(SELECT_ALL);
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
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;
	}

	@Override
	public User findEntityById(int id) throws DaoException {
		
		PreparedStatement pst = null;
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
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return user;
	}
	
	public User findUserByUsername(String username) throws DaoException {
		
		PreparedStatement pst = null;
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
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return user;
	}

	@Override
	public boolean delete(int id) throws DaoException {
		PreparedStatement pst = null;
		boolean result=false;
		try {
			pst = connection.prepareStatement(DELETE);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check != 0) {
				result = true;
			}
			
			
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) throws DaoException {
		boolean result=false;
		int id = entity.getId();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(DELETE);
			pst.setInt(1, id);
			int check = pst.executeUpdate();
			if (check != 0) {
				result = true;
			}
			
			
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean create(Entity entity) throws DaoException {
		boolean result=false;
		PreparedStatement pst = null;
		User user = (User) entity;
		try {
			pst = connection.prepareStatement(CREATE);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserType());
			int check = pst.executeUpdate();
			if (check != 0) {
				result = true;
			}
			
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);	
		}
		return result;
	}

	@Override
	public boolean update(Entity entity) throws DaoException {
		boolean result=false;
		User user = (User) entity;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getUserType());
			pst.setInt(4, user.getId());
			int check = pst.executeUpdate();
			if (check != 0) {
				result = true;
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return result;
	}

}
