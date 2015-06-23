package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.logic.LoginLogic;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public String execute(HttpServletRequest request) {
		String page = null;
		// извлечение из запроса логина и пароля
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		// проверка логина и пароля
		if (LoginLogic.checkLogin(login, pass)) {
			request.setAttribute("user", login);
			// определение пути к main.jsp
			page = ConfigurationManager.getProperty("path.page.main");
		} else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty("message.loginerror"));
			page = ConfigurationManager.getProperty("path.page.login");
		}
		return page;
	}
}