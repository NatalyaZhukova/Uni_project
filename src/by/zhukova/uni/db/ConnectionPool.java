package by.zhukova.uni.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ConnectionPool {
	
	static Logger logger = Logger.getLogger(ConnectionPool.class);
	
    public static Connection getConnection() {
	Context initContext;
	Connection conn = null;
	try {
		
		initContext = (Context) (new InitialContext().lookup("java:comp/env"));
		DataSource pool = (DataSource) initContext.lookup("jdbc/abitur");
		 conn = pool.getConnection();
	} catch (NamingException e ) {
		logger.error(e);
	} catch (SQLException e) {
		logger.error(e);
	} 
	return conn;
	
	
    }
}
