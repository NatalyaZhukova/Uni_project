/*
 * 
 */
package by.zhukova.uni.exception;


/**
 *Class {@code DaoException} is exception which is thrown when there are other exceptions in data access objects.
 *
 *@author Natallya Zhukova
 *@since 1.0
 */
public class DaoException extends Exception {

	/**
	 * Instantiates a new DAO exception.
	 */
	public DaoException() {
		
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param arg0 the arg0
	 */
	public DaoException(String arg0) {
		super(arg0);
		
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param arg0 the arg0
	 */
	public DaoException(Throwable arg0) {
		super(arg0);
		
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 */
	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	/**
	 * Instantiates a new DAO exception.
	 *
	 * @param arg0 the arg0
	 * @param arg1 the arg1
	 * @param arg2 the arg2
	 * @param arg3 the arg3
	 */
	public DaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
