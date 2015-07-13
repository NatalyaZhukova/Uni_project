/*
 * The package contains the classes which work with database
 */
package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.zhukova.uni.entity.User;
import by.zhukova.uni.exception.DaoException;

/**
 * Class {@code UserDAO} (data access object) is designed to work with database
 * table {@code users} and {@code User} objects.
 */
public class UserDAO extends AbstractDAO<User> {

	private final String SELECT_ALL = "SELECT * FROM users";
	private final String SELECT_BY_ID = "SELECT * FROM users WHERE id=?";
	private final String SELECT_BY_USERNAME = "SELECT * FROM users WHERE username=?"; // specific
																						// User
																						// method
	private final String DELETE = "DELETE FROM users WHERE id=?";
	private final String CREATE = "INSERT INTO users (username, password, user_type) VALUES (?, ?, ?)";
	private final String UPDATE = "UPDATE users SET  username=?, password=?, user_type=? WHERE id=?";

	/**
	 * Instantiates a new user DAO.
	 *
	 * @param connection
	 *            the connection
	 */
	public UserDAO(Connection connection) {
		super(connection);

	}

	/**
	 * Gets list of all users.
	 * 
	 * @return list of {@code User} objects - the list of users
	 * @throws DaoException
	 *             if there is SQLException
	 */
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

	/**
	 * Finds the user by given identifier
	 * 
	 * @param id
	 *            id of user
	 * @return {@code User} object - the faculty
	 * @throws DaoException
	 *             if there is SQLException
	 */
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

	/**
	 * Find user by username.
	 *
	 * @param username
	 *            the username
	 * @return {@code User}object - the user
	 * @throws DaoException
	 *             if there is SQLException
	 */
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

	/**
	 * Delete the user chosen by given identifier
	 * 
	 * @param id
	 *            identifier
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean delete(int id) throws DaoException {
		PreparedStatement pst = null;
		boolean result = false;
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

	/**
	 * Delete the user which was given as a parameter
	 * 
	 * @param user
	 *            - the user
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean delete(User user) throws DaoException {
		boolean result = false;
		int id = user.getId();
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

	/**
	 * Create the new user
	 * 
	 * @param user
	 *            - the user
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean create(User user) throws DaoException {
		boolean result = false;
		PreparedStatement pst = null;
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

	/**
	 * Update the user which was given as a parameter
	 * 
	 * @param user
	 *            - the user
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean update(User user) throws DaoException {
		boolean result = false;
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
