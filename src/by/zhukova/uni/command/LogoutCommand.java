package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.resource.ConfigurationManager;

public class LogoutCommand implements ActionCommand {
	private static final String PAGE_INDEX = "path.page.index";
	
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_INDEX);
		request.getSession().invalidate();
		return page;
	}
}
