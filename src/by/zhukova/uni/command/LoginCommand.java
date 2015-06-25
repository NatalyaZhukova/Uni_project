package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.logic.LoginLogic;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public String execute(HttpServletRequest request) {
		String page = null;
		
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		
		if (LoginLogic.checkLogin(login, pass)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", login);
			if (LoginLogic.isAdmin(login)) {
			page = ConfigurationManager.getProperty("path.page.main_admin");
			session.setAttribute("role", "admin");
			}
			else {
				session.setAttribute("role", "abiturient");
				page = ConfigurationManager.getProperty("path.page.main_user");
			}
		} else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}