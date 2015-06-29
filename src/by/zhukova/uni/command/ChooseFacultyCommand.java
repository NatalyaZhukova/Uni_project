package by.zhukova.uni.command;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class ChooseFacultyCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty("path.page.choose_fac");
		HttpSession session = request.getSession(true);

		List<Faculty> list = FacultyLogic.getFacultiesList();
		request.setAttribute("facList", list);

		String fName=request.getParameter("first_name");
		String mName = request.getParameter("middle_name");
		String lName = request.getParameter("last_name");
		
	

		if ((fName != null) || (mName != null) || (lName != null)) {
			
			if (Validation.isAllFieldFilled(fName, lName)) {
				if (Validation.validFIO(fName, mName, lName)) {
					request.setAttribute("fName", fName);
					request.setAttribute("mName", mName);
					request.setAttribute("lName", lName);
					int facultyId = Integer.parseInt(request
							.getParameter("faculty"));
					
	             
					Faculty fac = FacultyLogic.getChosenFaculty(facultyId);
					request.setAttribute("faculty", facultyId);
					request.setAttribute("faculty_name", fac.getName());
					List<Discipline> discList = DisciplineLogic.getFacultyDisciplines(fac);
					request.setAttribute("disciplines", discList);
					page = ConfigurationManager
							.getProperty("path.page.add_scores");
				} 
			else {
					request.setAttribute("errorMessage",
							MessageManager.getProperty("validation.format"));
				}
			} else {
				request.setAttribute("errorMessage",
						MessageManager.getProperty("validation.notfilled"));
			}
		}

		return page;
	}

}
