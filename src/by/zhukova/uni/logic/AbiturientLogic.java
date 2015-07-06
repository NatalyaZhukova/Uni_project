package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.AbiturientDAO;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.exception.DaoException;

public class AbiturientLogic {

	static Logger logger = Logger.getLogger(AbiturientLogic.class);

	public static boolean isApplicationExists(String username) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		Abiturient abitur = null;
		try {
			abitur = abiturDao.findAbiturByUsername(username);
		} catch (DaoException e1) {
			logger.error(e1);
		}

		if (abitur != null) {
			result = true;
		}

		pool.returnConnection(con);
		return result;
	}

	public static int calculateSchoolScore(double score) {

		return (int) (score * 10);
	}

	public static int calculateOverallScore(int first, int second, int third,
			int school) {
		return first + second + third + school;
	}

	public static boolean createApplication(Abiturient abitur) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		List<Abiturient> list = null;
		try {
			list = abiturDao.findAll();

			int id;
			if (list.size() == 0) {
				id = 1;
			} else {
				id = list.get(list.size() - 1).getId() + 1;
			}
			abitur.setId(id);
			result = abiturDao.create(abitur);
		} catch (DaoException e1) {
			logger.error(e1);
		}

		pool.returnConnection(con);
		return result;
	}

	public static Abiturient getAbiturApplication(String username) {
		Abiturient abitur = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		try {
			abitur = abiturDao.findAbiturByUsername(username);
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return abitur;
	}

	public static List<Abiturient> getAbitursByFaculty(int id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		List<Abiturient> list = null;
		try {
			list = abiturDao.findAbitursByFaculty(id);
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return list;

	}

	public static boolean deleteApplication(int id) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		try {
			result = abiturDao.delete(id);
		} catch (DaoException e1) {
			logger.error(e1);
		}

		pool.returnConnection(con);

		return result;

	}

}
