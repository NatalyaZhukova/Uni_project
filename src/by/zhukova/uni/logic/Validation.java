package by.zhukova.uni.logic;

public class Validation {
	
	public static boolean isAllFieldFilled(String ...args ) {
		boolean result = true;
		for (int i=0; i<args.length; i++) {
			if (args[i]==null){
				result=false;
				break;
			}
		}
		
		return result;
		
	}
	
	public static boolean passwordsEquals (String password, String password2) {
		if (password.equals(password2)) {
			return true;
		}
		return false;
	}
	
	public static boolean userFieldValid(String login, String password) {
		 final String LOGIN = "[A-Za-z\\d_]{5,50}";
		 final String PASSWORD = ".{5,20}";
		if ((login.matches(LOGIN)) && (password.matches(PASSWORD))) {
			return true;
		}
		return false;
	}
	
	public static boolean validFIO(String fName, String mName, String lName){
		boolean result = true;
		final String FIRST_NAME = "[À-ß¨à-ÿ¸]{2,30}";
		final String MIDDLE_NAME = "[À-ß¨à-ÿ¸]{2,30}";
		final String LAST_NAME = "[À-ß¨à-ÿ¸]{2,30}";
		if (!fName.matches(FIRST_NAME)) {
			result=false;
		}
		if ((mName!=null) && (!mName.equals("")) && (!mName.matches(MIDDLE_NAME))) {
			result=false;
		}
		if (!lName.matches(LAST_NAME)) {
			result=false;
		}
		
		
		return result;
	}
	
	public static boolean validScores(String first, String second, String third, String school) {
		final String TEST_SCORE = "([0-9]{1,2})|(100)";
		final String SCHOOL_SCORE = "(\\d\\.\\d)|(10\\.0)";
		
		boolean result = true;
		
		if (!first.matches(TEST_SCORE)) {
			result = false;
		}
		if (!second.matches(TEST_SCORE)) {
			result = false;
		}
		if (!third.matches(TEST_SCORE)) {
			result = false;
		}
		if (!school.matches(SCHOOL_SCORE)) {
			result = false;
		}

    return result; 
	}
	
	public static boolean validFaculty(String name, String plan) {
		final String FACULTY_NAME = "[À-ß¨][à-ÿ¸\\-]{2,30}";
		final String FACULTY_PLAN = "\\d{1,3}";
		
		boolean result = true;
		
		if (!name.matches(FACULTY_NAME)) {
			result = false;
		}
		if (!plan.matches(FACULTY_PLAN)) {
			result = false;
		}
		
		
		return result;
	}
	
	public static boolean noRepeatDisciplines(String disc1, String disc2, String disc3) {
		boolean result = true;
		
		if ((disc1.equals(disc2)) || (disc1.equals(disc3)) || (disc2.equals(disc3))) {
			result = false;
		}
		return result;
	}
}
