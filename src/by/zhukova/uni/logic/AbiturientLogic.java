package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.AbiturientDAO;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.exception.DaoException;
import by.zhukova.uni.resource.MessageManager;

public class AbiturientLogic {

	private final static String MESSAGE_APPROVED = "status.approved";
	private final static String MESSAGE_WAITING = "status.waiting";
	private final static String MESSAGE_DENIED = "status.denied";
	private final static int ONPAGE = 15;

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

	public static boolean updateAbiturient(Abiturient abitur) {
		boolean result = false;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		try {
			result = abiturDao.update(abitur);
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

	public static Abiturient getAbiturApplication(int id) {
		Abiturient abitur = null;
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		try {
			abitur = abiturDao.findEntityById(id);
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
	public static List<Abiturient> getAbitursByStatus(String status) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		List<Abiturient> list = null;
		try {
			list = abiturDao.findAbitursByStatus(status);
		} catch (DaoException e) {
			logger.error(e);
		}

		pool.returnConnection(con);

		return list;

	}
	
public static List<Abiturient> getFacultiesPage (int p, int numpage, List<Abiturient> list) {
		
		int onPage;
		int rows = list.size();

		if ((p>numpage) ||(p<1)) {
		p=1;
		}
		if (rows<ONPAGE) {onPage=rows; } else { onPage=p*ONPAGE; }
		if ((p==numpage) && (rows%ONPAGE>0)) {onPage=(p-1)*ONPAGE+rows%ONPAGE; }

		List<Abiturient> listPage = new ArrayList<Abiturient>();
		for ( int i=(p-1)*ONPAGE;i<onPage;i++) {
		   listPage.add(list.get(i));
		}

		return listPage;

		}

		public static int getLastPageNum( List<Abiturient> list) {
		int numpage;
		int rows = list.size();

		if (rows%ONPAGE!=0) {
		numpage = (int)(rows/ONPAGE)+1;
		}
		else {
		 numpage = (int)(rows/ONPAGE);
		}
		return numpage;
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

	public static String getApplicationStatus(String status) {
		String state = "";
		switch (status) {
		case "approved":
			state = MessageManager.getProperty(MESSAGE_APPROVED);
			break;
		case "waiting":
			state = MessageManager.getProperty(MESSAGE_WAITING);

			break;
		case "denied":
			state = MessageManager.getProperty(MESSAGE_DENIED);
		}
		return state;
	}

}
