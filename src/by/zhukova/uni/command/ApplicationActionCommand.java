package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ApplicationActionCommand is command which shows registered application to user
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ApplicationActionCommand implements ActionCommand {
	
	private static final String PAGE_APPLIC = "path.page.application";
	private static final String PAGE_MAIN = "path.page.main";
	private static final String PARAM_ACTION = "act";
	private static final String ACTION_DELETE = "del";
	private static final String ATTR_APPLICATION = "application";
/**
	 * The method gets data of user's own application from database, shows it on the defined page
	 * and allows user to delete it from database.
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
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
		String status = AbiturientLogic.getApplicationStatus(abitur.getStatus());
		
		request.setAttribute("appl", abitur);
		request.setAttribute("faculty", fac);
		request.setAttribute("faculty_registered", applicationsNum);
		request.setAttribute("status", status);
		
		String action = request.getParameter(PARAM_ACTION);
		if (action!=null) {
			if (action.equals(ACTION_DELETE)){
		
				int id = abitur.getId();
				if (AbiturientLogic.deleteApplication(id)) {
				session.removeAttribute(ATTR_APPLICATION);
				page = ConfigurationManager.getProperty(PAGE_MAIN);
				}
			}
		}
		
		return page;
	}
}
