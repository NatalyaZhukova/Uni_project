package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ConnectorDB {
	    
	static Logger logger = Logger.getLogger(ConnectorDB.class);
	
	public static Connection getConnection() throws SQLException {

    	
		ResourceBundle resource = ResourceBundle.getBundle("config");
		    String url = resource.getString("db.url");
		    String user = resource.getString("db.user");
		    String pass = resource.getString("db.password");
		  return DriverManager.getConnection(url, user, pass);
    	
        
        
	}
}
