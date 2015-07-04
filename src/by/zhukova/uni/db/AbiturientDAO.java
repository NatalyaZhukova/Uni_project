package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;

public class AbiturientDAO extends AbstractDAO {

	
	private final String SELECT_ALL = "SELECT * FROM abiturients";
	private final String SELECT_BY_ID = "SELECT * FROM abiturients WHERE id=?";
	private final String SELECT_BY_USERNAME = "SELECT * FROM abiturients WHERE username=?"; // specific Abiturient method
	private final String SELECT_BY_FACULTY = "SELECT * FROM abiturients WHERE chosen_faculty=?"; //specific Abiturient method
	private final String DELETE = "DELETE FROM abiturients WHERE id=?";
	private final String CREATE = "INSERT INTO abiturients (id, username, first_name, middle_name, last_name, discipline1_score, discipline2_score, "
				+ "discipline3_score, school_score, score_sum, chosen_faculty) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE abiturients SET username=?, first_name=?, middle_name=?, last_name=?, discipline1_score=?, discipline2_score=?, "
				+ "discipline3_score=?, school_score=?, score_sum=?, chosen_faculty=? WHERE id=?";

	public AbiturientDAO(Connection connection) {
		super(connection);

	}

	@Override
	public List<Abiturient> findAll() throws DaoException {
		List<Abiturient> list = new ArrayList<Abiturient>();
		PreparedStatement pst = null;
		try {
			 pst = connection.prepareStatement(SELECT_ALL);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Abiturient ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddleName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
				ab.setChosenFaculty(res.getInt(11));
				list.add(ab);
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}
	
	public List<Abiturient> findAbitursByFaculty(int facultyId) throws DaoException {
		List<Abiturient> list = new ArrayList<Abiturient>();
		PreparedStatement pst = null;
		try {
			 pst = connection.prepareStatement(SELECT_BY_FACULTY);
			pst.setInt(1, facultyId);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				Abiturient ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddleName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
				ab.setChosenFaculty(res.getInt(11));
				list.add(ab);
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}

	@Override
	public Abiturient findEntityById(int id) throws DaoException {
		PreparedStatement pst = null;
		Abiturient ab = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, id);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddleName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
				ab.setChosenFaculty(res.getInt(11));
			}
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return ab;
	}
	public Abiturient findAbiturByUsername(String username) throws DaoException {
		PreparedStatement pst = null;
		Abiturient ab = null;
		try {
			pst = connection.prepareStatement(SELECT_BY_USERNAME);
			pst.setString(1, username);
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				ab = new Abiturient();
				ab.setId(res.getInt(1));
				ab.setUsername(res.getString(2));
				ab.setFirstName(res.getString(3));
				ab.setMiddleName(res.getString(4));
				ab.setLastName(res.getString(5));
				ab.setFirstScore(res.getInt(6));
				ab.setSecondScore(res.getInt(7));
				ab.setThirdScore(res.getInt(8));
				ab.setSchoolScore(res.getInt(9));
				ab.setOverallScore(res.getInt(10));
				ab.setChosenFaculty(res.getInt(11));
			}
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return ab;
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
		boolean result = false;
		PreparedStatement pst = null;
		Abiturient ab = (Abiturient) entity;
		try {
			pst = connection.prepareStatement(CREATE);
			pst.setInt(1, ab.getId());
			pst.setString(2, ab.getUsername());
			pst.setString(3, ab.getFirstName());
			pst.setString(4, ab.getMiddlName());
			pst.setString(5, ab.getLastName());
			pst.setInt(6, ab.getFirstScore());
			pst.setInt(7, ab.getSecondScore());
			pst.setInt(8, ab.getThirdScore());
			pst.setInt(9, ab.getSchoolScore());
			pst.setInt(10, ab.getOverallScore());
			pst.setInt(11, ab.getChosenFaculty());
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
		Abiturient ab = (Abiturient) entity;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setInt(11, ab.getId());
			pst.setString(1, ab.getUsername());
			pst.setString(2, ab.getFirstName());
			pst.setString(3, ab.getMiddlName());
			pst.setString(4, ab.getLastName());
			pst.setInt(5, ab.getFirstScore());
			pst.setInt(6, ab.getSecondScore());
			pst.setInt(7, ab.getThirdScore());
			pst.setInt(8, ab.getSchoolScore());
			pst.setInt(9, ab.getOverallScore());
			pst.setInt(10, ab.getChosenFaculty());
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
