package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;

public class FacultyDAO extends AbstractDAO {

	
	private final String SELECT_ALL = "SELECT * FROM faculties";
	private final String SELECT_BY_ID = "SELECT * FROM faculties WHERE id_faculty=?";;
	private final String DELETE = "DELETE FROM faculties WHERE id_faculty=?";
	private final String CREATE = "INSERT INTO faculties (id_faculty, faculty_name, faculty_plan, discipline_1, discipline_2, discipline_3) VALUES (?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE disciplines SET  faculty_name=?, faculty_plan=?, discipline_1=?, discipline_2=?, discipline_3=? WHERE id_faculty=?";
	
	public FacultyDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<Faculty> findAll() throws DaoException {
		List<Faculty> list = new ArrayList<Faculty>();
		PreparedStatement pst = null;
		try {
			 pst = connection.prepareStatement(SELECT_ALL);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Faculty fac = new Faculty();
				fac.setId(res.getInt(1));
				fac.setName(res.getString(2));
				fac.setFacultyPlan(res.getInt(3));
				fac.setFirstDiscipline(res.getInt(4));
				fac.setSecondDiscipline(res.getInt(5));
				fac.setThirdDiscipline(res.getInt(6));
				list.add(fac);
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}

	@Override
	public Faculty findEntityById(int id) throws DaoException {
		PreparedStatement pst = null;
		Faculty fac = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				fac = new Faculty();
				fac.setId(res.getInt(1));
				fac.setName(res.getString(2));
				fac.setFacultyPlan(res.getInt(3));
				fac.setFirstDiscipline(res.getInt(4));
				fac.setSecondDiscipline(res.getInt(5));
				fac.setThirdDiscipline(res.getInt(6));
			}
			
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return fac;
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
		Faculty fac = (Faculty) entity;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);

			pst.setString(1, fac.getName());
			pst.setInt(2, fac.getFacultyPlan());
			pst.setInt(3, fac.getFirstDiscipline());
			pst.setInt(4, fac.getSecondDiscipline());
			pst.setInt(5, fac.getThirdDiscipline());
			pst.setInt(6, fac.getId());
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
