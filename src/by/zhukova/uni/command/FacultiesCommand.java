package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

public class FacultiesCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.showfaculties");
		
		List<Faculty> list = FacultyLogic.getFacultiesList();
		//request.setAttribute("facList", list);
		int pageNum;
		if (request.getParameter("p")==null) {
			pageNum=1;
		}
		else {
			try {
			pageNum=Integer.parseInt(request.getParameter("p"));
			}
			catch (NumberFormatException e) {
				pageNum=1;
			}
		 
		int lastPage = FacultyLogic.getLastPageNum(list);
		
		
		request.setAttribute("numpage", pageNum);
		List<Faculty> listPart = FacultyLogic.getFacultiesPage(pageNum, lastPage, list);
		request.setAttribute("facList", listPart);
		
		
	}
		return page;

} }
