/*
 * The package contains the classes which work with database
 */
package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;

/**
 * Class {@code AbstractDAO} is abstract template for data access objects of
 * classes-inheritors of class {@code Entity}
 *
 * @param <T>
 *            the generic type
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public abstract class AbstractDAO<T extends Entity> {

	protected Connection connection;

	/** The logger. */
	static Logger logger = Logger.getLogger(AbstractDAO.class);

	/**
	 * Instantiates a new abstract DAO.
	 *
	 * @param connection
	 *            the connection
	 */
	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Gets list of all entities.
	 *
	 * @return the list
	 * @throws DaoException
	 *             if there is SQLException
	 */
	public abstract List<T> findAll() throws DaoException;

	/**
	 * Find entity by id.
	 *
	 * @param id
	 *            the id
	 * @return the inheritor of class {@code Entity}
	 * @throws DaoException
	 *             if there is SQLException
	 */
	public abstract T findEntityById(int id) throws DaoException;

	/**
	 * Delete chosen entity by identifier.
	 *
	 * @param id
	 *            the id
	 * @return true, if successful
	 * @throws DaoException
	 *             the dao exception
	 */
	public abstract boolean delete(int id) throws DaoException;

	/**
	 * Delete given entity.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	public abstract boolean delete(T entity) throws DaoException;

	/**
	 * Create the entity.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	public abstract boolean create(T entity) throws DaoException;

	/**
	 * Update the entity.
	 *
	 * @param entity
	 *            the entity
	 * @return true, if successful
	 * @throws DaoException
	 *             if there is SQLException
	 */
	public abstract boolean update(T entity) throws DaoException;

	/**
	 * Close statement.
	 *
	 * @param st
	 *            the {@code Statement} object
	 */
	public void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
