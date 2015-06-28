package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.resource.ConfigurationManager;

public class ApplicationActionCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.application");
		
		
		
		
		return page;
	}

}
