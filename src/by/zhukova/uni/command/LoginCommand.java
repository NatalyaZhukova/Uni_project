package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.LoginLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class LoginCommand implements ActionCommand {
	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";
	private static final String ROLE_USER = "abiturient";
	private static final String ROLE_ADMIN = "admin";
	private static final String STATUS_WAITING = "waiting";
	private static final String ATTR_APPLIC = "exists";

	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_LOGIN = "path.page.login";

	private static final String MESSAGE_LOGINERROR = "message.loginerror";
	private static final String MESSAGE_FORMATERROR = "validation.format";

	public String execute(HttpServletRequest request) {
		String page = null;
		
		String login = request.getParameter(PARAM_NAME_LOGIN);
		String pass = request.getParameter(PARAM_NAME_PASSWORD);
		if (Validation.userFieldValid(login, pass)) {
			if (LoginLogic.checkLogin(login, pass)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", login);
				page = ConfigurationManager.getProperty(PAGE_MAIN);
				if (LoginLogic.isAdmin(login)) {
			
					session.setAttribute("role", ROLE_ADMIN);
				}
				else {
					session.setAttribute("role", ROLE_USER);
					if (AbiturientLogic.isApplicationExists(login)) {
						session.setAttribute("application", ATTR_APPLIC);
					}
				}
			} else {
				request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty(MESSAGE_LOGINERROR));
				page = ConfigurationManager.getProperty(PAGE_LOGIN);
			} 
		
		}
		else {
			request.setAttribute("errorLoginPassMessage",
					MessageManager.getProperty(MESSAGE_FORMATERROR));
			page = ConfigurationManager.getProperty(PAGE_LOGIN);
		}
		return page;
	}
}