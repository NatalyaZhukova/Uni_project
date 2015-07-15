package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ShowFacultiesCommand is command which shows list of existing
 * faculties
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ShowFacultiesCommand implements ActionCommand {

	private static final String PAGE_SHOW_FACULTIES = "path.page.showfaculties";
	private static final String PARAM_PAGE = "p";

	/**
	 * The method gets list of faculties from database and shows it on defined
	 * page. List of faculties is divided by pages.
	 *
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);
		

		page = ConfigurationManager.getProperty(PAGE_SHOW_FACULTIES);

		List<Faculty> list = FacultyLogic.getFacultiesList();

		int pageNum;
		if (request.getParameter(PARAM_PAGE) == null) {
			pageNum = 1;
		} else {
			try {
				pageNum = Integer.parseInt(request.getParameter(PARAM_PAGE));
			} catch (NumberFormatException e) {
				pageNum = 1;
			}
		}

		int lastPage = FacultyLogic.calcLastPageNum(list);

		request.setAttribute("numpage", lastPage);
		List<Faculty> listPart = FacultyLogic.getFacultiesPage(pageNum, lastPage, list);
		request.setAttribute("facList", listPart);

		return page;

	}
}
