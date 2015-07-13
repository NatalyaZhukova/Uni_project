
package by.zhukova.uni.test;

import org.junit.Test;

import java.sql.Connection;

import org.junit.Assert;

import by.zhukova.uni.db.ConnectionPool;

/**
 * The Class {@code ConnectionPoolTest} is designed to test the class
 * {@code by.zhukova.uni.db.ConnectionPool}.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ConnectionPoolTest {

	/**
	 * Test method {@code getInstance()} .
	 *
	 * 
	 */
	@Test
	public void getInstanceTest() {
		ConnectionPool pool = ConnectionPool.getInstance();
		boolean expected = true;
		boolean actual;
		if (pool != null) {
			actual = true;
		} else {
			actual = false;
		}

		Assert.assertEquals(expected, actual);
	}

	/**
	 * Test the method {@code getConnection()}
	 *
	 * 
	 */
	@Test
	public void getConnectionTest() {
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection con = pool.getConnection();
		boolean expected = true;
		boolean actual;
		if (con != null) {
			actual = true;
		} else {
			actual = false;
		}

		Assert.assertEquals(expected, actual);

	}

}
