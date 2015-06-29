package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.FacultyDAO;
import by.zhukova.uni.entity.Entity;
import by.zhukova.uni.entity.Faculty;

public class FacultyLogic {
	
	static Logger logger = Logger.getLogger(FacultyLogic.class);
	
	public static List<Faculty> getFacultiesList() {
		Connection con = ConnectionPool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		List<Faculty> list = facDao.findAll();
		
		try {
			con.close();
		} catch (SQLException e) {
		 logger.error(e);
		}
		
		return list;
		
	}
	
	public static Faculty getChosenFaculty(int id) {
		Connection con = ConnectionPool.getConnection();
		FacultyDAO facDao = new FacultyDAO(con);
		Faculty faculty = facDao.findEntityById(id);
		
		try {
			con.close();
		} catch (SQLException e) {
		 logger.error(e);
		}
		
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
