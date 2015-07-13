package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.resource.ConfigurationManager;
/**
 * The Class LangCommand is command which allows to switch pages' locale.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class LangCommand implements ActionCommand {
	private static final String PARAM_LOCALE = "loc";
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PAGE_INDEX = "path.page.index";
/**
	 * The method gets locale as a parameter and writes it to session attribute.
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		String lang = request.getParameter(PARAM_LOCALE);
		session.setAttribute("locale", lang);
		
		 
		if (session.getAttribute("user")!=null) {
			page=ConfigurationManager.getProperty(PAGE_MAIN);
			
		} 
		else {
			page=ConfigurationManager.getProperty(PAGE_INDEX);
		}

		
		
		return page;
	}

}
