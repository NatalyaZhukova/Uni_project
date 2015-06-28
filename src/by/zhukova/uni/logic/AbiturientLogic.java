package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.AbiturientDAO;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.entity.Abiturient;

public class AbiturientLogic {
	
	static Logger logger = Logger.getLogger(AbiturientLogic.class);
	
	public static boolean isApplicationExists(String username) {
		boolean result = false;
		Connection con = ConnectionPool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		Abiturient abitur = abiturDao.findAbiturByUsername(username);
		
		if (abitur!=null) {
			result=true;
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	
	public static int calculateSchoolScore(double score) {
		
		return (int)(score*10);
	}
	
	public static int calculateOverallScore (int first, int second, int third, int school ) {
		return first + second + third + school;
	}
	
	public static boolean createApplication(Abiturient abitur) {
		boolean result;
		Connection con = ConnectionPool.getConnection();
		AbiturientDAO abiturDao = new AbiturientDAO(con);
		List<Abiturient> list = abiturDao.findAll();
		int id;
		if (list.size()==0) {
			id=1;
		} else {
		 id = list.get(list.size()-1).getId()+1;
		}
		abitur.setId(id);
		System.out.println(abitur.toString());
		result=abiturDao.create(abitur);
		
		
		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		return result;
	}
	
	
	
	

}
