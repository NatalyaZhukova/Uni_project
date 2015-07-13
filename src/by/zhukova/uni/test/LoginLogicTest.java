package by.zhukova.uni.test;

import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.LoginLogic;

/**
 * The Class {@code LoginLogicTest} is designed to test the class
 * {@code by.zhukova.uni.logic.LoginLogic}.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class LoginLogicTest {

	/**
	 * Test of checking login.
	 */
	@Test
	public void checkLoginTest() {
		String login = "student";
		String password = "123456";

		boolean expected = true;

		boolean actual = LoginLogic.checkLogin(login, password);

		Assert.assertEquals(expected, actual);

	}
}
