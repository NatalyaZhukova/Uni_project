package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;

public class EmptyCommand implements ActionCommand {
	public String execute(HttpServletRequest request) {
		String page=null;
		HttpSession session = request.getSession(true);
		if (session.getAttribute("user")!=null) {
			page=ConfigurationManager.getProperty("path.page.main");
		}
		else {
		 page = ConfigurationManager.getProperty("path.page.login");
		 }
		return page;
	}
}