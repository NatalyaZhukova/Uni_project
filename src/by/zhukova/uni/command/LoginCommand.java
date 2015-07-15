package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.LoginLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class LoginCommand is command which allows to log in the system
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String ROLE_USER = "abiturient";
	private static final String ROLE_ADMIN = "admin";

	private static final String ATTR_APPLIC = "exists";

	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_LOGIN = "path.page.login";

	private static final String MESSAGE_LOGINERROR = "message.loginerror";
	private static final String MESSAGE_FORMATERROR = "validation.format";

	/**
	 * The method gets user data from form, validates and checks it. If such
	 * user and password exist, then method defines the main page as the page to
	 * redirect.
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	public String execute(HttpServletRequest request) {
		String page = null;
		
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);

		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		if (Validation.userFieldValid(login, pass)) {
			if (LoginLogic.checkLogin(login, pass)) {
				session.setAttribute("user", login);
				page = ConfigurationManager.getProperty(PAGE_MAIN);
				if (LoginLogic.isAdmin(login)) {

					session.setAttribute("role", ROLE_ADMIN);
				} else {
					session.setAttribute("role", ROLE_USER);
					if (AbiturientLogic.isApplicationExists(login)) {
						session.setAttribute("application", ATTR_APPLIC);
					}
				}
			} else {
				request.setAttribute("errorLoginPassMessage", MESSAGE_LOGINERROR);
				page = ConfigurationManager.getProperty(PAGE_LOGIN);
			}

		} else {
			request.setAttribute("errorLoginPassMessage", MESSAGE_FORMATERROR);
			page = ConfigurationManager.getProperty(PAGE_LOGIN);
		}
		return page;
	}
}