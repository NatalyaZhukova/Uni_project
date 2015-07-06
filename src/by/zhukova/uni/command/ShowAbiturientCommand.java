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

public class ShowAbiturientCommand implements ActionCommand {
	
	private static final String PAGE_INFO = "path.page.show_abiturient";
	private static final String PARAM_ID = "id";

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_INFO);
		
		int abiturient;
		String requestedId = request.getParameter(PARAM_ID);
	
		try {
		 abiturient=Integer.parseInt(requestedId);
		}
		catch (NumberFormatException e) {
			abiturient=1;
		}
		
		
		Abiturient abitur = AbiturientLogic.getAbiturApplication(abiturient);
		if (abitur==null) {
			abiturient=1;
			abitur = AbiturientLogic.getAbiturApplication(abiturient);
		}
		
		Faculty fac = FacultyLogic.getChosenFaculty(abitur.getChosenFaculty());
		List<Discipline> discList = DisciplineLogic.getFacultyDisciplines(fac);
		request.setAttribute("abiturient", abitur);
		request.setAttribute("faculty", fac);
		request.setAttribute("discList", discList);
		double schoolScore = (double)abitur.getSchoolScore()/10;
		request.setAttribute("schoolScore", schoolScore);
		
		
		return page;
	}

}
