package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

public class ApplicationActionCommand implements ActionCommand {
	
	private static final String PAGE_APPLIC = "path.page.application";
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PARAM_ACTION = "act";

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_APPLIC);
		
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("user");
		Abiturient abitur = AbiturientLogic.getAbiturApplication(username);
		int faculty = abitur.getChosenFaculty();
		Faculty fac = FacultyLogic.getChosenFaculty(faculty);
		List<Abiturient> list = AbiturientLogic.getAbitursByFaculty(faculty);
		int applicationsNum = list.size();
		
		request.setAttribute("appl", abitur);
		request.setAttribute("faculty", fac);
		request.setAttribute("faculty_registered", applicationsNum);
		
		String action = request.getParameter(PARAM_ACTION);
		if (action!=null) {
			if (action.equals("del")){
		
				int id = abitur.getId();
				if (AbiturientLogic.deleteApplication(id)) {
				session.removeAttribute("application");
				page = ConfigurationManager.getProperty(PAGE_MAIN);
				}
			}
		}
		
		return page;
	}
}
