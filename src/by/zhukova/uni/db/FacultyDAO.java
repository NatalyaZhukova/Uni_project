package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.entity.Entity;

public class FacultyDAO extends AbstractDAO {

	static Logger logger = Logger.getLogger(FacultyDAO.class);

	public FacultyDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<Faculty> findAll() {
		List<Faculty> list = new ArrayList<Faculty>();
		String query = "SELECT * FROM disciplines";
		try {
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Faculty fac = new Faculty();
				fac.setId(res.getInt(1));
				fac.setName(res.getString(2));
				fac.setFacultyPlan(res.getInt(3));
				fac.setFirstDiscipline(res.getInt(4));
				fac.setSecondDiscipline(res.getInt(5));
				fac.setThirdDiscipline(res.getInt(5));
				list.add(fac);
			}
			super.close(pst);

		} catch (SQLException e) {
			logger.error(e);
		}
		return list;

	}

	@Override
	public Faculty findEntityById(int id) {
		String query = "SELECT * FROM faculties WHERE id=?";
		PreparedStatement pst;
		Faculty fac = null;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				fac.setId(res.getInt(1));
				fac.setName(res.getString(2));
				fac.setFacultyPlan(res.getInt(3));
				fac.setFirstDiscipline(res.getInt(4));
				fac.setSecondDiscipline(res.getInt(5));
				fac.setThirdDiscipline(res.getInt(5));
			}
			super.close(pst);
		} catch (SQLException e) {
			logger.error(e);
		}

		return fac;
	}

	@Override
	public boolean delete(int id) {
		String query = "DELETE FROM faculties WHERE id=?";
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
		String query = "DELETE FROM faculties WHERE id=?";
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
		String query = "INSERT INTO faculties (id_faculty, faculty_name, faculty_plan, discipline_1, discipline_2, discipline_3) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pst;
		Faculty fac = (Faculty) entity;
		try {
			pst = connection.prepareStatement(query);
			pst.setInt(1, fac.getId());
			pst.setString(2, fac.getName());
			pst.setInt(3, fac.getFacultyPlan());
			pst.setInt(4, fac.getFirstDiscipline());
			pst.setInt(5, fac.getSecondDiscipline());
			pst.setInt(6, fac.getThirdDiscipline());

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
		Faculty fac = (Faculty) entity;
		String query = "UPDATE disciplines SET  faculty_name=?, faculty_plan=?, discipline_1=?, discipline_2=?, discipline_3=? WHERE id_faculty=?";
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(query);

			pst.setString(1, fac.getName());
			pst.setInt(2, fac.getFacultyPlan());
			pst.setInt(3, fac.getFirstDiscipline());
			pst.setInt(4, fac.getSecondDiscipline());
			pst.setInt(5, fac.getThirdDiscipline());
			pst.setInt(6, fac.getId());
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
