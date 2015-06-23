package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestRun {
	

	static {
		PropertyConfigurator.configure("log4j.properties");
	}
	static Logger logger = Logger.getLogger(TestRun.class);

	public static void main(String[] args) {
		
		 final String SQL_SELECT = "SELECT * FROM disciplines";
		   Connection connect=null;
				connect = ConnectionPool.getConnection();
			
	
		    PreparedStatement ps = null;
		  try {
		   ps = connect.prepareStatement(SQL_SELECT);
		   ResultSet result = ps.executeQuery();
		   while (result.next()) {
			   System.out.println(result.getInt(1));
			   System.out.println(result.getString(2));
		   }
		   
		  } catch (SQLException e) {
		
		   e.printStackTrace();
		  }
	

	}

}
