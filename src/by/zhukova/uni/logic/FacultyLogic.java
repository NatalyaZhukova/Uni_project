package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.FacultyDAO;
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

}
