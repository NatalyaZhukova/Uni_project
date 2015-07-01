package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;

public class DisciplineDAO extends AbstractDAO {

	
	private final String SELECT_ALL = "SELECT * FROM disciplines";
	private final String SELECT_BY_ID = "SELECT * FROM disciplines WHERE id_discipline=?";
	private final String DELETE = "DELETE FROM disciplines WHERE id_discipline=?";
	private final String CREATE = "INSERT INTO disciplines (id_discipline, discipline_name) VALUES (?, ?)";
	private final String UPDATE = "UPDATE disciplines SET  discipline_name=? WHERE id_discipline=?";

	public DisciplineDAO(Connection connection) {
		super(connection);
	}

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
		}
		finally {
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
		Discipline dis = (Discipline) entity;
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

	@Override
	public boolean update(Entity entity) throws DaoException {
		boolean result=false;
		Discipline dis = (Discipline) entity;
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
		}
		finally {
			close(pst);
		}
		return result;
	}

}
