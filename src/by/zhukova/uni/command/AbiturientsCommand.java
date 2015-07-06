package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class AbiturientsCommand implements ActionCommand {
	
	private static final String PAGE_LIST = "page.path.abiturient_faculty";
	private static final String PARAM_FACULTY_ID = "faculty";
	private static final String MESSAGE_NO_APPLIC = "message.no_application";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		page = ConfigurationManager.getProperty(PAGE_LIST);
		
		List<Faculty> facList = FacultyLogic.getFacultiesList();
		request.setAttribute("facList", facList);
		
		String facultyId = request.getParameter(PARAM_FACULTY_ID);
		int id;
		if (facultyId!=null) {
			id = Integer.parseInt(facultyId);
		} else {
			id=facList.get(0).getId();
		}
		
		Faculty fac = FacultyLogic.getChosenFaculty(id);
		String facultyName = fac.getName();
		int plan = fac.getFacultyPlan();
		request.setAttribute("facultyName", facultyName);
		List<Abiturient> abiturients = AbiturientLogic.getAbitursByFaculty(id);
		int quantApplic = abiturients.size();
		int stopLine=1;
		if (quantApplic==0) {
			request.setAttribute("message", MessageManager.getProperty(MESSAGE_NO_APPLIC));
		} else if (quantApplic<=plan) {
			stopLine = quantApplic;
		} else if (quantApplic>plan) {
			stopLine=plan;
		}
		request.setAttribute("plan", plan);
		request.setAttribute("stopLine", stopLine);
		request.setAttribute("applicNums", quantApplic);
		request.setAttribute("abiturients", abiturients);
		
		
		return page;
	}

}
