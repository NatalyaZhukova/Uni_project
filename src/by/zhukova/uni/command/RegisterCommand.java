package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.logic.RegisterLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ApplicationActionCommand is command which allows to register new
 * user.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class RegisterCommand implements ActionCommand {

	private static final String PARAM_NAME_LOGIN = "reg_login";
	private static final String PARAM_NAME_PASSWORD = "reg_password";
	private static final String PARAM_NAME_REP_PASSWORD = "repeat_password";

	private static final String PAGE_SUCCESS = "path.page.success_reg";
	private static final String PAGE_ERROR = "path.page.error";
	private static final String PAGE_REGISTER = "path.page.register";

	private static final String MESSAGE_USER_EXISTS = "message.user_exists";
	private static final String MESSAGE_INVALID_FORMAT = "validation.format";
	private static final String MESSAGE_REPEAT = "validation.repeat";
	private static final String MESSAGE_NOT_FILLED = "validation.notfilled";
	private static final String MESSAGE_ERROR = "error.no_user";

	/**
	 * The method gets user's data from form, validates and checks it, then
	 * writes it to database.
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);
		
		String page = ConfigurationManager.getProperty(PAGE_REGISTER);
		if (request.getParameter(PARAM_NAME_LOGIN) != null) {
			String login = request.getParameter(PARAM_NAME_LOGIN);
			String password = request.getParameter(PARAM_NAME_PASSWORD);
			String repPassword = request.getParameter(PARAM_NAME_REP_PASSWORD);

			if (Validation.isAllFieldFilled(login, password, repPassword)) {
				if (Validation.passwordsEquals(password, repPassword)) {
					if (Validation.userFieldValid(login, password)) {
						if (RegisterLogic.checkLoginAvailable(login)) {
							if (RegisterLogic.addNewUser(login, password)) {
								page = ConfigurationManager.getProperty(PAGE_SUCCESS);
							} else {
								request.setAttribute("errorMessage", MESSAGE_ERROR);
								page = ConfigurationManager.getProperty(PAGE_ERROR);
							}

						} else {
							request.setAttribute("errorUserMessage", MESSAGE_USER_EXISTS);
						}
					} else {
						request.setAttribute("errorUserMessage", MESSAGE_INVALID_FORMAT);
					}
				} else {
					request.setAttribute("errorUserMessage", MESSAGE_REPEAT);
				}
			} else {
				request.setAttribute("errorUserMessage", MESSAGE_NOT_FILLED);
			}

		}
		return page;
	}

}
