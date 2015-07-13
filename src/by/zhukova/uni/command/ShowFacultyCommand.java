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
/**
 * The Class ShowFacultyCommand is command which shows list of faculties.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ShowFacultyCommand implements ActionCommand {
	
	private static final String PAGE_FACULTY = "path.page.showfaculty";
	private static final String PARAM_ID = "id";
/**
	 * The method gets data of faculty from database by given identifier and shows it on the defined page.
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		int faculty;
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
