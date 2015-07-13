package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ApplicationActionCommand is command which allow to log out
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class LogoutCommand implements ActionCommand {
	private static final String PAGE_INDEX = "path.page.index";

	/**
	 * The method destroys existing session and define given page as the page to
	 * redirect.
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_INDEX);
		request.getSession().invalidate();
		return page;
	}
}
