package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import by.zhukova.uni.db.AbiturientDAO;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.exception.DaoException;
import by.zhukova.uni.resource.MessageManager;
/** 
* The Class AbiturientLogic contains the methods which work with {@code Abiturient} objects
*
* @author Natallya Zhukova
* @since 1.0
*/
public class AbiturientLogic {

	private final static String MESSAGE_APPROVED = "status.approved";
	private final static String MESSAGE_WAITING = "status.waiting";
	private final static String MESSAGE_DENIED = "status.denied";
	private final static int ONPAGE = 15;
	public final static int TO_DOUBLE_DIGIT = 10;

	static Logger logger = Logger.getLogger(AbiturientLogic.class);
/** 
* The method checks if the application of given user is exists.
* @param username
* @return true, if there is the application with given username in the database.
*/
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
/** 
* The method transforms  average school mark to double-digit integer number.
* @param average school mark
* @return integer double-digit number.
*/
	public static int calculateSchoolScore(double score) {

		return (int) (score * TO_DOUBLE_DIGIT);
	}
/** 
* The method calculates sum of all required scores.
* @param scores of first, second, third disciplines and transformed average school mark
* @return sum of scores
*/
	public static int calculateOverallScore(int first, int second, int third,
			int school) {
		return first + second + third + school;
	}
/** 
* The method creates the given application in database
* @param {@code Abiturient} object
* @return true, if successful
*/
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
/** 
* The method updates abiturient's data in database
* @param {@code Abiturient} object
* @return true, if successful
*/
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

	/** 
	* The method gets application from database by given username
	* @param username
	* @return {@code Abiturient} object - the application
	*/
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
   /** 
   * The method gets application from database by given identifier
   * @param id
   * @return {@code Abiturient} object - the application
   */
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
 /** 
 * The method gets the list of the application with status "approved" by given faculty
 * @param id
 * @return {@code List<Abiturient>} list - the list of applications
 */
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
	
/** 
 * The method gets the list of the application  by given status
 * @param status
 * @return {@code List<Abiturient>} list - the list of applications
 */
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
/** 
* The method gets the list of the applications which should be shown on current page
* @param page number, quantity of pages, list of application
* @return {@code List<Abiturient>} list - the list of applications
*/
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
/** 
* The method calculates the number of pages that list can be divided
* @param list of applications
* @return number of last page
*/
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

/** 
* The method deletes the application by given identifier
* @param id
* @return true, if successful
*/
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
 /** 
 * The method gets status name from locale properties file.
 * @param status
 * @return string
 */
	public static String getApplicationStatus(String status) {
		String state = "";
		switch (status) {
		case "approved":
			state = MESSAGE_APPROVED;
			break;
		case "waiting":
			state = MESSAGE_WAITING;

			break;
		case "denied":
			state = MESSAGE_DENIED;
		}
		return state;
	}

}
