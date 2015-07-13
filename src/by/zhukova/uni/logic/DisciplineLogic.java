package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.DisciplineDAO;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.exception.DaoException;

/**
 * The Class DisciplineLogic contains the methods which work with
 * {@code Discipline} objects
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class DisciplineLogic {

	static Logger logger = Logger.getLogger(DisciplineLogic.class);

	/**
	 * The method gets list of disciplines for given faculty
	 * 
	 * @param fac
	 *            faculty
	 * @return {@code List<Discipline>} list - list of disciplines
	 */
	public static List<Discipline> getFacultyDisciplines(Faculty fac) {
		List<Discipline> list = new ArrayList<Discipline>();
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		DisciplineDAO discDao = new DisciplineDAO(con);
		int first = fac.getFirstDiscipline();
		int second = fac.getSecondDiscipline();
		int third = fac.getThirdDiscipline();
		try {
			list.add(discDao.findEntityById(first));
			list.add(discDao.findEntityById(second));
			list.add(discDao.findEntityById(third));
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return list;

	}

	/**
	 * The method gets list of all disciplines in database
	 *
	 * @return {@code List<Discipline>} list - the list of disciplines
	 */
	public static List<Discipline> getAllDisciplines() {
		List<Discipline> list = new ArrayList<Discipline>();
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		DisciplineDAO discDao = new DisciplineDAO(con);

		try {
			list = discDao.findAll();
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return list;

	}

}
