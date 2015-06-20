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

	public DisciplineDAO(Connection connection) {
		super(connection);
	}

	@Override
	public List<Discipline> findAll() {
		List<Discipline> list = new ArrayList<Discipline>();
		String query = "SELECT * FROM disciplines";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Discipline dis = new Discipline();
				dis.setId(res.getInt(1));
				dis.setName(res.getString(2));
				list.add(dis);
			}
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
		}
		return list;

	}

	@Override
	public Discipline findEntityById(int id) {
		String query = "SELECT * FROM disciplines WHERE id=?";
		PreparedStatement pst;
		Discipline dis = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				dis = new Discipline();
				dis.setId(res.getInt(1));
				dis.setName(res.getString(2));
			}
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
		}

		return dis;
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM disciplines WHERE id=?";
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
		String query = "DELETE FROM disciplines WHERE id=?";
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
		String query = "INSERT INTO disciplines (id, name) VALUES (?, ?)";
		PreparedStatement pst;
		Discipline dis = (Discipline) entity;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, dis.getId());
			pst.setString(2, dis.getName());
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
		Discipline dis = (Discipline) entity;
		String query = "UPDATE disciplines SET  name=? WHERE id=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, dis.getName());
			pst.setInt(2, dis.getId());
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
