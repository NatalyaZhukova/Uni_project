package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ApplicationActionCommand is command which executes if command name
 * is empty
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class EmptyCommand implements ActionCommand {
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_LOGIN = "path.page.login";

	/**
	 * The method defines page to redirect
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */

	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user") != null) {
			page = ConfigurationManager.getProperty(PAGE_MAIN);
		} else {
			page = ConfigurationManager.getProperty(PAGE_LOGIN);
		}
		return page;
	}
}