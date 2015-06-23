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
	private final String SELECT_ALL = "SELECT * FROM faculties";
	private final String SELECT_BY_ID = "SELECT * FROM faculties WHERE id=?";;
	private final String DELETE = "DELETE FROM faculties WHERE id=?";
	private final String CREATE = "INSERT INTO faculties (id_faculty, faculty_name, faculty_plan, discipline_1, discipline_2, discipline_3) VALUES (?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE disciplines SET  faculty_name=?, faculty_plan=?, discipline_1=?, discipline_2=?, discipline_3=? WHERE id_faculty=?";
	
	public FacultyDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<Faculty> findAll() {
		List<Faculty> list = new ArrayList<Faculty>();
		try {
			PreparedStatement pst = connection.prepareStatement(SELECT_ALL);
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
			

		} catch (SQLException e) {
			logger.error(e);
		} finally {
			close(pst);
		}
		return list;

	}

	@Override
	public Faculty findEntityById(int id) {
		PreparedStatement pst;
		Faculty fac = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_ID);
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
			
		} catch (SQLException e) {
			logger.error(e);
		} finally {
			close(pst);
		}

		return fac;
	}

	@Override
	public boolean delete(int id) {
		PreparedStatement pst;
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
		} finally {
			close(pst);
		}
		return result;
	}

	@Override
	public boolean delete(Entity entity) {
		boolean result;
		int id = entity.getId();
		PreparedStatement pst;
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
		PreparedStatement pst;
		Faculty fac = (Faculty) entity;
		try {
			pst = connection.prepareStatement(CREATE);
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
		Faculty fac = (Faculty) entity;
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement(UPDATE);

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
			

		} catch (SQLException e) {
			logger.error(e);
			result = false;
		} finally {
			close(pst);
		}
		return result;
	}

}
