package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

public class FacultiesCommand implements ActionCommand {

	private static final String PAGE_SHOW_FACULTIES = "path.page.showfaculties";
	private static final String PAGE_FACULTIES = "path.page.faculties";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		HttpSession session = request.getSession(true);

		if (session.getAttribute("role").equals("admin")) {
			page = ConfigurationManager.getProperty(PAGE_FACULTIES);
		} else {
			page = ConfigurationManager.getProperty(PAGE_SHOW_FACULTIES);
		}

		List<Faculty> list = FacultyLogic.getFacultiesList();
		// request.setAttribute("facList", list);

		int pageNum;
		if (request.getParameter("p") == null) {
			pageNum = 1;
		} else {
			try {
				pageNum = Integer.parseInt(request.getParameter("p"));
			} catch (NumberFormatException e) {
				pageNum = 1;
			}
		}

		int lastPage = FacultyLogic.getLastPageNum(list);

		request.setAttribute("numpage", lastPage);
		List<Faculty> listPart = FacultyLogic.getFacultiesPage(pageNum,
				lastPage, list);
		if ((listPart == null) || (listPart.size() == 0)) {
			System.out.println("Something is WRONG!");
		}
		request.setAttribute("facList", listPart);

		return page;

	}
}
