package by.zhukova.uni.logic;

/**
 * The Class Validation contains the methods which check if given object matches
 * the pattern
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class Validation {
	/**
	 * The method checks if all given fields are filled
	 * 
	 * @param args
	 *            several strings
	 * @return false if there is empty field
	 */
	public static boolean isAllFieldFilled(String... args) {
		boolean result = true;
		for (int i = 0; i < args.length; i++) {
			if ((args[i] == null) || (args[i] == "")) {
				result = false;
				break;
			}
		}

		return result;

	}

	/**
	 * The method checks if the given passwords equals
	 * 
	 * @param password
	 *            the password
	 * @param password2
	 *            the repeated password
	 * @return true, if equal
	 */
	public static boolean passwordsEquals(String password, String password2) {
		if (password.equals(password2)) {
			return true;
		}
		return false;
	}

	/**
	 * The method checks if the given user and password match the patterns
	 * 
	 * @param login
	 *            the login
	 * @param password
	 *            the password
	 * @return true, if match
	 */
	public static boolean userFieldValid(String login, String password) {
		final String LOGIN = "[A-Za-z\\d_]{5,50}";
		final String PASSWORD = ".{5,20}";
		if ((login.matches(LOGIN)) && (password.matches(PASSWORD))) {
			return true;
		}
		return false;
	}

	/**
	 * The method checks if the given first name, middle name, last name match
	 * the patterns
	 * 
	 * @param fName
	 *            the first name
	 * @param mName
	 *            the middle name
	 * @param lName
	 *            the last name
	 * @return true, if match
	 */
	public static boolean validFIO(String fName, String mName, String lName) {
		boolean result = true;
		final String FIRST_NAME = "[А-ЯЁа-яё]{2,30}";
		final String MIDDLE_NAME = "[А-ЯЁа-яё]{2,30}";
		final String LAST_NAME = "[А-ЯЁа-яё]{2,30}";
		if (!fName.matches(FIRST_NAME)) {
			result = false;
		}
		if ((mName != null) && (!mName.equals("")) && (!mName.matches(MIDDLE_NAME))) {
			result = false;
		}
		if (!lName.matches(LAST_NAME)) {
			result = false;
		}

		return result;
	}

	/**
	 * The method checks if the given scores match the patterns
	 * 
	 * @param first
	 *            score of first discipline
	 * @param second
	 *            score of second discipline
	 * @param third
	 *            score of third discipline
	 * @param school
	 *            average school mark
	 * @return true, if match
	 */
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

	/**
	 * The method checks if the given faculty name and plan match the patterns
	 * 
	 * @param name
	 *            faculty name
	 * @param plan
	 *            faculty plan
	 * @return true, if match
	 */
	public static boolean validFaculty(String name, String plan) {
		final String FACULTY_NAME = "[А-ЯЁ][а-яё\\-]{2,30}";
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

	/**
	 * The method checks if the identifiers of given disciplines don't repeat
	 * themselves
	 * 
	 * @param disc1
	 *            id of first discipline
	 * @param disc2
	 *            id of second discipline
	 * @param disc3
	 *            id of third discipline
	 * @return true, if don't repeat
	 */
	public static boolean noRepeatDisciplines(String disc1, String disc2, String disc3) {
		boolean result = true;

		if ((disc1.equals(disc2)) || (disc1.equals(disc3)) || (disc2.equals(disc3))) {
			result = false;
		}
		return result;
	}
}
