package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Entity;

public class DisciplineDAO extends AbstractDAO {

	static Logger logger = Logger.getLogger(DisciplineDAO.class);
	private final String SELECT_ALL = "SELECT * FROM disciplines";
	private final String SELECT_BY_ID = "SELECT * FROM disciplines WHERE id=?";
	private final String DELETE = "DELETE FROM disciplines WHERE id=?";
	private final String CREATE = "INSERT INTO disciplines (id, name) VALUES (?, ?)";
	private final String UPDATE = "UPDATE disciplines SET  name=? WHERE id=?";

	public DisciplineDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<Discipline> findAll() {
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
			logger.error(e);
		} finally {
		  	close(pst);
		}
		return list;

	}

	@Override
	public Discipline findEntityById(int id) {
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
			logger.error(e);
		} finally {
			close(pst);
		}

		return dis;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement pst = null;
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
		}
		finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) {
		boolean result;
		int id = entity.getId();
		PreparedStatement pst = null;
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
		PreparedStatement pst = null;
		Discipline dis = (Discipline) entity;
		try {
			pst = connection.prepareStatement(CREATE);
			pst.setInt(1, dis.getId());
			pst.setString(2, dis.getName());
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
		Discipline dis = (Discipline) entity;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setString(1, dis.getName());
			pst.setInt(2, dis.getId());
			int check = pst.executeUpdate();
			if (check == 0) {
				result = false;
			}
			result = true;
		

		} catch (SQLException e) {
			logger.error(e);
			result = false;
		}
		finally {
			close(pst);
		}
		return result;
	}

}
