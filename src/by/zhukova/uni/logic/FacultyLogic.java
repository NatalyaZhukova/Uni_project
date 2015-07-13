package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.AbiturientDAO;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.FacultyDAO;
import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.exception.DaoException;

/**
 * The Class FacultyLogic contains the methods which work with {@code Faculty}
 * objects
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class FacultyLogic {

	static Logger logger = Logger.getLogger(FacultyLogic.class);
	private final static int ONPAGE = 5;

	/**
	 * The method gets the list of all faculties in database
	 *
	 * @return {@code List<Faculty>} list - the list of faculties
	 */
	public static List<Faculty> getFacultiesList() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		List<Faculty> list = null;
		try {
			list = facDao.findAll();
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return list;

	}

	/**
	 * The method checks if faculty with given identifier is exist
	 * 
	 * @param id
	 *            the faculty id
	 * @return true, if exist
	 */
	public static boolean isIdExists(int id) {
		boolean result = false;
		List<Faculty> list = getFacultiesList();
		for (int i = 0; i < list.size(); i++) {
			if (id == list.get(i).getId()) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * The method checks if there is registered application with given chosen
	 * faculty
	 * 
	 * @param id
	 *            the faculty id
	 * @return true, if exist
	 */
	public static boolean isApplicationsExist(int id) {
		boolean result = false;

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		try {
			List<Abiturient> list = abiturDao.findApprovedAbitursByFaculty(id);
			if (list.size() != 0) {
				result = true;
			}
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);
		return result;
	}

	/**
	 * The method gets faculty by given id
	 * 
	 * @param id
	 *            the faculty id
	 * @return faculty
	 */
	public static Faculty getChosenFaculty(int id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		Faculty faculty = null;
		try {
			faculty = facDao.findEntityById(id);
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return faculty;
	}

	/**
	 * The method creates the new faculty in database
	 * 
	 * @param fac
	 *            faculty
	 * @return true, if successful
	 */
	public static boolean createFaculty(Faculty fac) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);

		List<Faculty> list = null;
		try {
			list = facDao.findAll();
			int id;
			if (list.size() == 0) {
				id = 1;
			} else {
				id = list.get(list.size() - 1).getId() + 1;
			}
			fac.setId(id);
			result = facDao.create(fac);

		} catch (DaoException e1) {
			logger.error(e1);
		}
		pool.returnConnection(con);
		return result;

	}

	/**
	 * The method deletes faculty with given id
	 * 
	 * @param id
	 *            the faculty id
	 * @return true, if successful
	 */
	public static boolean deleteFaculty(int id) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);

		try {
			result = facDao.delete(id);

		} catch (DaoException e1) {
			logger.error(e1);
		}
		pool.returnConnection(con);
		return result;
	}

	/**
	 * The method allows to edit faculty data and updates it in database
	 * 
	 * @param fac
	 *            faculty
	 * @return true, if successful
	 */
	public static boolean editFaculty(Faculty fac) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);

		try {
			result = facDao.update(fac);

		} catch (DaoException e1) {
			logger.error(e1);
		}
		pool.returnConnection(con);
		return result;
	}

	/**
	 * The method gets the list of the faculties which should be shown on
	 * current page
	 * 
	 * @param p
	 *            page number
	 * @param numPages
	 *            quantity of pages
	 * @param list
	 *            list of faculties
	 * @return {@code List<Faculty>} list - the list of faculties
	 */
	public static List<Faculty> getFacultiesPage(int p, int numPages, List<Faculty> list) {

		int onPage;
		int rows = list.size();

		if ((p > numPages) || (p < 1)) {
			p = 1;
		}
		if (rows < ONPAGE) {
			onPage = rows;
		} else {
			onPage = p * ONPAGE;
		}
		if ((p == numPages) && (rows % ONPAGE > 0)) {
			onPage = (p - 1) * ONPAGE + rows % ONPAGE;
		}

		List<Faculty> listPage = new ArrayList<Faculty>();
		for (int i = (p - 1) * ONPAGE; i < onPage; i++) {
			listPage.add(list.get(i));
		}

		return listPage;

	}

	/**
	 * The method calculates the number of pages that list can be divided
	 * 
	 * @param list
	 *            list of faculties
	 * @return number of last page
	 */
	public static int calcLastPageNum(List<Faculty> list) {
		int numPages;
		int rows = list.size();

		if (rows % ONPAGE != 0) {
			numPages = (int) (rows / ONPAGE) + 1;
		} else {
			numPages = (int) (rows / ONPAGE);
		}
		return numPages;
	}

}
