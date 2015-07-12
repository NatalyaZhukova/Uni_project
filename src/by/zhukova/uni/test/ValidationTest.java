package by.zhukova.uni.test;

import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.Validation;

public class ValidationTest {
	
	@Test
	public void isAllFieldFilledTest(){
		String first = "first";
		String second = "second";
		String third = "third";
		
		boolean expected = true;
		boolean actual = Validation.isAllFieldFilled(first, second, third);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void emptyFieldsExistsTest() {
		String first ="first";
		String second = "";
		String third = "third";
		
		boolean expected=false;
		boolean actual = Validation.isAllFieldFilled(first, second, third);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void userFieldValidTest() {
		String login = "Username";
		String password = "fw3s3f9lsf-(#20jdsf";
		
		boolean expected=true;
		boolean actual = Validation.userFieldValid(login, password);
		
		Assert.assertEquals(expected, actual);
	}

}
