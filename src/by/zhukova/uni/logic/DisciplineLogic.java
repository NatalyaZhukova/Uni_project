package by.zhukova.uni.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.db.DisciplineDAO;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;

public class DisciplineLogic {
	
	static Logger logger = Logger.getLogger(DisciplineLogic.class);
	
	public static List<Discipline> getFacultyDisciplines(Faculty fac) {
		List<Discipline> list = new ArrayList<Discipline>();
		Connection con = ConnectionPool.getConnection();
		DisciplineDAO discDao = new DisciplineDAO(con);
		int first = fac.getFirstDiscipline();
		int second = fac.getSecondDiscipline();
	    int third = fac.getThirdDiscipline();
		list.add(discDao.findEntityById(first));
		list.add(discDao.findEntityById(second));
		list.add(discDao.findEntityById(third));
		
		try {
			con.close();
		} catch (SQLException e) {
			logger.error(e);
		}
		
		
		return list;
		
		
	}

}
