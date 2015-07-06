package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;

public class LangCommand implements ActionCommand {
	private static final String LOCALE = "locale";
	private static final String ROLE_ADMIN = "admin";
	private static final String PAGE_REGISTER = "register";
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_INDEX = "path.page.index";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		String lang = request.getParameter(LOCALE);
		if (session.getAttribute("user")!=null) {
			page=ConfigurationManager.getProperty(PAGE_MAIN);
			
		} 
		else {
			page=ConfigurationManager.getProperty(PAGE_INDEX);
		}
		session.setAttribute("locale", lang);
		
		
		
		return page;
	}

}
