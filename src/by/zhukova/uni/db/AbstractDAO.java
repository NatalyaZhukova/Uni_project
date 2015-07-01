package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;

public abstract class AbstractDAO<T extends Entity> {
	protected Connection connection;
	static Logger logger = Logger.getLogger(AbstractDAO.class);

	public AbstractDAO(Connection connection) {
		this.connection = connection;
	}

	public abstract List<T> findAll() throws DaoException;

	public abstract T findEntityById(int id) throws DaoException;

	public abstract boolean delete(int id) throws DaoException;

	public abstract boolean delete(T entity) throws DaoException;

	public abstract boolean create(T entity) throws DaoException;

	public abstract boolean update(T entity) throws DaoException;

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
