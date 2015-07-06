package by.zhukova.uni.db;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static  Logger logger = Logger
            .getLogger(ConnectionPool.class);

    public static final String PATH_LOG4J = "resources/log4j.properties";
    private static final String PARAM_URL = "db.url";
    private static final String PARAM_USER = "db.user";
    private static final String PARAM_PASSWORD = "db.password";

    static {
        PropertyConfigurator.configure(PATH_LOG4J);
    }

    private static ConnectionPool instance = null;
    private static Lock lock = new ReentrantLock();
    private static AtomicBoolean takeConnection = new AtomicBoolean(true);
    private static AtomicBoolean createPool = new AtomicBoolean(false);
    private final static int POOL_SIZE = 5;
    private BlockingQueue<Connection> pool;



    private ConnectionPool() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            ResourceBundle resource = ResourceBundle.getBundle("database");

            String url = resource.getString(PARAM_URL);
            String login = resource.getString(PARAM_USER);
            String password = resource.getString(PARAM_PASSWORD);

            pool = new ArrayBlockingQueue<>(POOL_SIZE);

            for (int i = 0; i <= POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(url, login,
                        password);

                pool.offer(connection);
                
            }

        } catch (SQLException | ClassNotFoundException e) {
            logger.fatal("fatal exception in ConnectionPool class ", e);
            throw new RuntimeException("",e);
        }
    }

    public static ConnectionPool getInstance() {
        if (!createPool.get()) {
            lock.lock();
            try{
            if (instance == null) {
                instance = new ConnectionPool();
                createPool.set(true);
            }
            } finally {
                lock.unlock(); 
            }
        }
        return instance;
    }


    public Connection getConnection()  {
        Connection connection = null;

        if (takeConnection.get()) {
            try {
                connection = pool.take();
            } catch (InterruptedException e) {
                logger.error("InterruptedException ", e);
            } 
        }
        return connection;
    }


    public void returnConnection(Connection connection) {
        try {
            if (!connection.isClosed()) {
                pool.add(connection);
            }
        } catch (SQLException e) {
            logger.error("SQLException in returnConnection method ", e);
        }
    }


    public void cleanUp()   {

        takeConnection = new AtomicBoolean(false);
        try {
            
            Iterator<Connection> iterator = pool.iterator();
            while (iterator.hasNext()) {
                Connection connection = iterator.next();

                if (connection != null) {
                    connection.close();
                }
                iterator.remove();
            }
        } catch (SQLException e) {
            logger.error("SQLException in cleanUp method", e);
        }
    }
}