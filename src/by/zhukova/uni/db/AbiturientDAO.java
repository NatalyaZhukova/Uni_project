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

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.exception.DaoException;


/**
 *  Class {@code AbiturientDAO} (data access object) is designed to work with database table {@code abiturients} 
 *  and {@code Abiturient} objects.
 *  
 *  @author Natallya Zhukova
 *  @since 1.0
 */
public class AbiturientDAO extends AbstractDAO {

	
	private final String SELECT_ALL = "SELECT * FROM abiturients";
	private final String SELECT_BY_ID = "SELECT * FROM abiturients WHERE id=?";
	private final String SELECT_BY_USERNAME = "SELECT * FROM abiturients WHERE username=?"; 
	private final String SELECT_BY_FACULTY = "SELECT * FROM abiturients WHERE chosen_faculty=? and status='approved' ORDER BY score_sum DESC"; 
	private final String SELECT_BY_STATUS = "SELECT * FROM abiturients WHERE status=?";
	private final String DELETE = "DELETE FROM abiturients WHERE id=?";
	private final String CREATE = "INSERT INTO abiturients (id, username, first_name, middle_name, last_name, discipline1_score, discipline2_score, "
				+ "discipline3_score, school_score, score_sum, chosen_faculty, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String UPDATE = "UPDATE abiturients SET username=?, first_name=?, middle_name=?, last_name=?, discipline1_score=?, discipline2_score=?, "
				+ "discipline3_score=?, school_score=?, score_sum=?, chosen_faculty=?, status=? WHERE id=?";

	/**
	 * Instantiates a new Abiturient data access object.
	 *
	 * @param connection the connection
	 */
	public AbiturientDAO(Connection connection) {
		super(connection);

	}

	/** 
	 * Gets list of all registered applications.
	 * 
	 * @return  list of {@code Abiturient} objects - the list of applications
	 * @throws {@code DaoException} if there is SQLException
	 */
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
	
	/**
	 * Find registered applications with status "approved"  by chosen faculty.
	 *
	 * @param facultyId the faculty identifier
	 * @return list of {@code Abiturient} objects) - the list of applications
	 * @throws DaoException if there is SQLException
	 */
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
				ab.setStatus(res.getString(12));
				list.add(ab);
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}
	
	/**
	 * Find registered applications by given status.
	 *
	 * @param status the status
	 * @return {@code List<Abiturient> list} - the list of applications
	 * @throws DaoException if there is SQLException
	 */
	public List<Abiturient> findAbitursByStatus(String status) throws DaoException {
		List<Abiturient> list = new ArrayList<Abiturient>();
		PreparedStatement pst = null;
		try {
			 pst = connection.prepareStatement(SELECT_BY_STATUS);
			pst.setString(1, status);
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
				ab.setStatus(res.getString(12));
				list.add(ab);
			}
			

		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}
		return list;

	}

	/**
	 * Finds the application by given identifier
	 * 
	 * @param id id of application
	 * @return {@code Abiturient} object - the application
	 * @throws DaoException if there is SQLException
	 */
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
				ab.setStatus(res.getString(12));
			}
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return ab;
	}
	
	/**
	 * Find the application by given username.
	 *
	 * @param username the username
	 * @return {@code Abiturient} object - the application
	 * @throws DaoException if there is SQLException
	 */
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
				ab.setStatus(res.getString(12));
			}
		} catch (SQLException e) {
			throw new DaoException(e.toString());
		} finally {
			close(pst);
		}

		return ab;
	}

	/**
	 * Delete the application chosen by given identifier
	 * 
	 * @param id identifier
	 * @return result - true if deleting was successful
	 * @throws DaoException if there is SQLException
	 */
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

	/**
	 * Delete the application which was given as a parameter
	 * The method overrides the class {@code Entity} method
	 * 
	 * @param {@Entity} entity - {@code Abiturient} object inherited from {@code Entity} class
	 * @return result - true if deleting was successful
	 * @throws DaoException if there is SQLException
	 */
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

	/**
	 * Create the new application 
	 * The method overrides the class {@code Entity} method
	 * 
	 * @param {@Entity} entity - {@code Abiturient} object inherited from {@code Entity} class
	 * @return result - true if creating was successful
	 * @throws DaoException if there is SQLException
	 */
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
			pst.setString(4, ab.getMiddleName());
			pst.setString(5, ab.getLastName());
			pst.setInt(6, ab.getFirstScore());
			pst.setInt(7, ab.getSecondScore());
			pst.setInt(8, ab.getThirdScore());
			pst.setInt(9, ab.getSchoolScore());
			pst.setInt(10, ab.getOverallScore());
			pst.setInt(11, ab.getChosenFaculty());
			pst.setString(12, ab.getStatus());
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
	 * Update the application which was given as a parameter
	 * The method overrides the class {@code Entity} method
	 * 
	 * @param {@Entity} entity - {@code Abiturient} object inherited from {@code Entity} class
	 * @return result - true if update was successful
	 * @throws DaoException if there is SQLException
	 */
	@Override
	public boolean update(Entity entity) throws DaoException {
		boolean result=false;
		Abiturient ab = (Abiturient) entity;
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(UPDATE);
			pst.setInt(12, ab.getId());
			pst.setString(1, ab.getUsername());
			pst.setString(2, ab.getFirstName());
			pst.setString(3, ab.getMiddleName());
			pst.setString(4, ab.getLastName());
			pst.setInt(5, ab.getFirstScore());
			pst.setInt(6, ab.getSecondScore());
			pst.setInt(7, ab.getThirdScore());
			pst.setInt(8, ab.getSchoolScore());
			pst.setInt(9, ab.getOverallScore());
			pst.setInt(10, ab.getChosenFaculty());
			pst.setString(11, ab.getStatus());
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
