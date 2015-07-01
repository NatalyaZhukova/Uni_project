package by.zhukova.uni.logic;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.FacultyDAO;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.exception.DaoException;

public class FacultyLogic {
	
	static Logger logger = Logger.getLogger(FacultyLogic.class);
	
	public static List<Faculty> getFacultiesList() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		List<Faculty> list=null;
		try {
			list = facDao.findAll();
		} catch (DaoException e) {
			logger.error(e);
		}
		
		pool.returnConnection(con);
		
		return list;
		
	}
	
	public static Faculty getChosenFaculty(int id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		Faculty faculty=null;
		try {
			faculty = facDao.findEntityById(id);
		} catch (DaoException e) {
			logger.error(e);
		}
		
	    pool.returnConnection(con);
		
		return faculty;
	}
	
	private final static int ONPAGE = 5;

	public static List<Faculty> getFacultiesPage (int p, int numpage, List<Faculty> list) {
	
	int onPage;
	int rows = list.size();

	if ((p>numpage) ||(p<1)) {
	p=1;
	}
	if (rows<ONPAGE) {onPage=rows; } else { onPage=p*ONPAGE; }
	if ((p==numpage) && (rows%ONPAGE>0)) {onPage=(p-1)*ONPAGE+rows%ONPAGE; }

	List<Faculty> listPage = new ArrayList<Faculty>();
	for ( int i=(p-1)*ONPAGE;i<onPage;i++) {
	   listPage.add(list.get(i));
	}

	return listPage;

	}

	public static int getLastPageNum( List<Faculty> list) {
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

	

}
