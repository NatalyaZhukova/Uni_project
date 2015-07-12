package by.zhukova.uni.test;
import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.LoginLogic;

public class LoginLogicTest {

	@Test
	public void checkLoginTest() {
		String login="student";
		String password="123456";
		
		boolean expected=true;
		
		boolean actual=LoginLogic.checkLogin(login, password);
		
		Assert.assertEquals(expected, actual);
		
	}
}
