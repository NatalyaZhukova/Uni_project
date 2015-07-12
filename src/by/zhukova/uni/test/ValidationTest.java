/*
 * 
 */
package by.zhukova.uni.test;

import org.junit.Assert;
import org.junit.Test;

import by.zhukova.uni.logic.Validation;


/**
 * /**
 * The Class {@code ValidationTest} is designed to test the class
 *  {@code by.zhukova.uni.logic.Validation}.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
 
public class ValidationTest {
	
	/**
	 * Test of the method which checks if is all field filled .
	 */
	@Test
	public void isAllFieldFilledTest(){
		String first = "first";
		String second = "second";
		String third = "third";
		
		boolean expected = true;
		boolean actual = Validation.isAllFieldFilled(first, second, third);
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test of the method {@code isAllFieldFilled(String..args)} if one of fields is empty
	 */
	@Test
	public void emptyFieldsExistsTest() {
		String first ="first";
		String second = "";
		String third = "third";
		
		boolean expected=false;
		boolean actual = Validation.isAllFieldFilled(first, second, third);
		
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * Test of method which checks if username and password match patterns
	 */
	@Test
	public void userFieldValidTest() {
		String login = "Username";
		String password = "fw3s3f9lsf-(#20jdsf";
		
		boolean expected=true;
		boolean actual = Validation.userFieldValid(login, password);
		
		Assert.assertEquals(expected, actual);
	}

}
