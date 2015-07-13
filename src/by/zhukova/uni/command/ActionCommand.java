package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The Interface ActionCommand is template for commands.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public interface ActionCommand {

	/**
	 * Execute.
	 *
	 * @param request
	 *            the request
	 * @return the string - the page path
	 * @see by.zhukova.uni.control.Controller
	 */
	String execute(HttpServletRequest request);
}