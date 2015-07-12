package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_LOGIN = "path.page.login";
	
	public String execute(HttpServletRequest request) {
		String page=null;
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user")!=null) {
			page=ConfigurationManager.getProperty(PAGE_MAIN);
		}
		else {
		 page = ConfigurationManager.getProperty(PAGE_LOGIN);
		 }
		return page;
	}
}