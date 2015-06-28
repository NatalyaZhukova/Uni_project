package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.logic.RegisterLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class RegisterCommand implements ActionCommand {

	private static final String PARAM_NAME_LOGIN = "reg_login";
	private static final String PARAM_NAME_PASSWORD = "reg_password";
	private static final String PARAM_NAME_REP_PASSWORD = "repeat_password";

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.register");
		if (request.getParameter(PARAM_NAME_LOGIN) != null) {
			String login = request.getParameter(PARAM_NAME_LOGIN);
			String password = request.getParameter(PARAM_NAME_PASSWORD);
			String repPassword = request.getParameter(PARAM_NAME_REP_PASSWORD);
			
			if (Validation.isAllFieldFilled(login, password, repPassword)) {
				if (Validation.passwordsEquals(password, repPassword)) {
					if (Validation.userFieldValid(login, password)) {
						if (RegisterLogic.checkLoginAvailable(login)) {
							if (RegisterLogic.addNewUser(login, password)) {
								page = ConfigurationManager
										.getProperty("path.page.success_reg");
							}
							else {
								page = ConfigurationManager.getProperty("path.page.error");
							}

						} else {
							request.setAttribute("errorUserMessage",
									MessageManager.getProperty("message.user_exists"));
						}
					}
					else {
						request.setAttribute("errorUserMessage", MessageManager.getProperty("validation.format"));
					}
				}
				else {
					request.setAttribute("errorUserMessage", MessageManager.getProperty("validation.repeat"));
				}
			} else {
				request.setAttribute("errorUserMessage", MessageManager.getProperty("validation.notfilled"));
			}

			
		}
		return page;
	}

}
