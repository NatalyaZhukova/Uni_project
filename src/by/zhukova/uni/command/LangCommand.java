package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;

public class LangCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		String lang = request.getParameter("locale");
		if (session.getAttribute("user")!=null) {
			if (session.getAttribute("role").equals("admin")) {
			page=ConfigurationManager.getProperty("path.page.main_admin");
			}
			else {
			page=ConfigurationManager.getProperty("path.page.main_user");
			}
		} else {
			page=ConfigurationManager.getProperty("path.page.index");
		}
		session.setAttribute("locale", lang);
		
		
		
		return page;
	}

}
