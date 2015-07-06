package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

public class ShowFacultyCommand implements ActionCommand {
	
	private static final String PAGE_FACULTY = "path.page.showfaculty";
	private static final String PARAM_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int faculty=1;
		String requestedId = request.getParameter(PARAM_ID);
	
		try {
		 faculty=Integer.parseInt(requestedId);
		}
		catch (NumberFormatException e) {
			faculty=1;
		}
		
		
		Faculty fac = FacultyLogic.getChosenFaculty(faculty);
		if (fac==null) {
			faculty=1;
			fac = FacultyLogic.getChosenFaculty(faculty);
		}
		List<Abiturient> list = AbiturientLogic.getAbitursByFaculty(faculty);
		int applicationsNum = list.size();
		List<Discipline> discList = DisciplineLogic.getFacultyDisciplines(fac);
		
		request.setAttribute("faculty", fac);
		request.setAttribute("discList", discList);
		request.setAttribute("applications", applicationsNum);
		
		page = ConfigurationManager.getProperty(PAGE_FACULTY);
		
		
		
		
		
		return page;
	}

}
