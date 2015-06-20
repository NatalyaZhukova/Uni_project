package by.zhukova.uni.db;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectorDB {
	    
	static Logger logger = Logger.getLogger(ConnectorDB.class);
	
	public static Connection getConnection() throws SQLException {

		Properties prop = new Properties();
    	InputStream input;
		try {
			input = new FileInputStream(Constants.DB_PROPERTIES);
			prop.load(input);
	        String url = prop.getProperty("db.url");
	        String name = prop.getProperty("db.user");
	        String password = prop.getProperty("db.password");
	        return DriverManager.getConnection(url, name, password);
		} catch ( IOException e) {
			logger.error(e.getMessage());
		}
    	
        return null;
        
	}
}
