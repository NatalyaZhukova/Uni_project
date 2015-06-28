package by.zhukova.uni.command;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class AddScoresCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
     String page = ConfigurationManager.getProperty("path.page.add_scores");

		String first = request.getParameter("disc1");
		String second = request.getParameter("disc2");
		String third = request.getParameter("disc3");
		String school = request.getParameter("school");
		
		
		String first_name = request.getParameter("first_name");
		
		
		String middle_name = request.getParameter("middle_name");
		if (middle_name==null) {
			middle_name="";
		}
		String last_name = request.getParameter("last_name");
		
		int chosen_faculty = Integer.parseInt(request.getParameter("faculty"));
		Faculty fac = FacultyLogic.getChosenFaculty(chosen_faculty);
		List<Discipline> list = DisciplineLogic.getFacultyDisciplines(fac);
		String faculty_name = request.getParameter("faculty_name");
		
		if ((first!=null) || (second!=null) || (third!=null) || (school!=null)) {
			if (Validation.isAllFieldFilled(first, second, third, school)) {
				if (Validation.validScores(first, second, third, school)) {
				
					int first_score = Integer.parseInt(first);
					int second_score = Integer.parseInt(second);
					int third_score = Integer.parseInt(third);
					int school_score = AbiturientLogic.calculateSchoolScore(Double.parseDouble(school));
					int overall = AbiturientLogic.calculateOverallScore(first_score, second_score, third_score, school_score);
					
					HttpSession session = request.getSession(true);
					String username = (String) session.getAttribute("user");
					
					Abiturient abitur = new Abiturient();
					abitur.setUsername(username);
					abitur.setFirstName(first_name);
					abitur.setMiddlName(middle_name);
					abitur.setLastName(last_name);
					abitur.setFirstScore(first_score);
					abitur.setSecondScore(second_score);
					abitur.setThirdScore(third_score);
					abitur.setSchoolScore(school_score);
					abitur.setOverallScore(overall);
					abitur.setChosenFaculty(chosen_faculty);
					System.out.println(abitur.toString());
					
					if (AbiturientLogic.createApplication(abitur)) {
						page = ConfigurationManager
								.getProperty("path.page.application");
						request.setAttribute("application", abitur);
						
					}
					else {
						page = ConfigurationManager.getProperty("path.page.error");
					}
					
				}
				else {
					request.setAttribute("errorMessage", MessageManager.getProperty("validation.format"));
					
				}
				
			}
			else {
				request.setAttribute("errorMessage",
						MessageManager.getProperty("validation.notfilled"));
			}
			
		}
		request.setAttribute("fName", first_name);
		request.setAttribute("mName", middle_name);
		request.setAttribute("lName", last_name);
		request.setAttribute("faculty", chosen_faculty);
		request.setAttribute("faculty_name", faculty_name);
		request.setAttribute("disciplines", list);
		
		return page;
	}

}
