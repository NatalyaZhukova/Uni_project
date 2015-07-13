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

import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.exception.DaoException;

/**
 * Class {@code DisciplineDAO} (data access object) is designed to work with
 * database table {@code disciplines} and {@code Discipline} objects.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class DisciplineDAO extends AbstractDAO<Discipline> {

	private final String SELECT_ALL = "SELECT * FROM disciplines";
	private final String SELECT_BY_ID = "SELECT * FROM disciplines WHERE id_discipline=?";
	private final String DELETE = "DELETE FROM disciplines WHERE id_discipline=?";
	private final String CREATE = "INSERT INTO disciplines (id_discipline, discipline_name) VALUES (?, ?)";
	private final String UPDATE = "UPDATE disciplines SET  discipline_name=? WHERE id_discipline=?";

	/**
	 * Instantiates a new discipline DAO.
	 *
	 * @param connection
	 *            the connection
	 */
	public DisciplineDAO(Connection connection) {
		super(connection);
	}

	/**
	 * Gets list of all disciplines.
	 * 
	 * @return list of {@code Discipline} objects - the list of disciplines
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public List<Discipline> findAll() throws DaoException {
		List<Discipline> list = new ArrayList<Discipline>();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(SELECT_ALL);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Discipline dis = new Discipline();
				dis.setId(res.getInt(1));
				dis.setName(res.getString(2));
				list.add(dis);
			}

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}

	/**
	 * Finds the discipline by given identifier
	 * 
	 * @param id
	 *            id of discipline
	 * @return {@code Discipline} object - the discipline
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public Discipline findEntityById(int id) throws DaoException {
		PreparedStatement pst = null;
		Discipline dis = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				dis = new Discipline();
				dis.setId(res.getInt(1));
				dis.setName(res.getString(2));
			}
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return dis;
	}

	/**
	 * Delete the discipline chosen by given identifier
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
	 * Delete the discipline which was given as a parameter
	 * 
	 * @param dis
	 *            - the discipline
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean delete(Discipline dis) throws DaoException {
		boolean result = false;
		int id = dis.getId();
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
	 * Create the new discipline
	 * 
	 * @param dis
	 *            - the discipline
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean create(Discipline dis) throws DaoException {
		boolean result = false;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(CREATE);
			pst.setInt(1, dis.getId());
			pst.setString(2, dis.getName());
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
	 * Update the discipline which was given as a parameter
	 * 
	 * @param dis
	 *            - the discipline
	 * @return result - true if it was successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	@Override
	public boolean update(Discipline dis) throws DaoException {
		boolean result = false;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setString(1, dis.getName());
			pst.setInt(2, dis.getId());
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
