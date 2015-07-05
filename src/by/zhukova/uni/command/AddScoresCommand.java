package by.zhukova.uni.command;

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

	private final static String PAGE_ADD_SCORES = "path.page.add_scores";
	private final static String PAGE_ERROR = "path.page.error";
	private final static String PAGE_SUCCESS = "path.page.success_application";

	private final static String PARAM_DISC1 = "disc1";
	private final static String PARAM_DISC2 = "disc2";
	private final static String PARAM_DISC3 = "disc3";
	private final static String PARAM_SCHOOL = "school";
	private final static String ATTR_FACULTY_NAME = "faculty_name";
	private final static String ATTR_ABITUR = "abiturient";
	private final static String ATTR_USER = "user";
	private final static String ATTR_APPLIC = "exists";

	private final static String MESSAGE_VALIDATION_FORMAT = "validation.format";
	private final static String MESSAGE_NOT_FILLED = "validation.notfilled";
	private final static String MESSAGE_ERROR = "error.no_application";

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String page = ConfigurationManager.getProperty(PAGE_ADD_SCORES);

		Abiturient abitur = (Abiturient) session.getAttribute(ATTR_ABITUR);

		String first = request.getParameter(PARAM_DISC1);
		String second = request.getParameter(PARAM_DISC2);
		String third = request.getParameter(PARAM_DISC3);
		String school = request.getParameter(PARAM_SCHOOL);

		int chosen_faculty = abitur.getChosenFaculty();
		Faculty fac = FacultyLogic.getChosenFaculty(chosen_faculty);
		List<Discipline> list = DisciplineLogic.getFacultyDisciplines(fac);
		String faculty_name = (String) request.getAttribute(ATTR_FACULTY_NAME);

		if ((first != null) || (second != null) || (third != null)
				|| (school != null)) {
			if (Validation.isAllFieldFilled(first, second, third, school)) {
				if (Validation.validScores(first, second, third, school)) {

					int first_score = Integer.parseInt(first);
					int second_score = Integer.parseInt(second);
					int third_score = Integer.parseInt(third);
					int school_score = AbiturientLogic
							.calculateSchoolScore(Double.parseDouble(school));
					int overall = AbiturientLogic.calculateOverallScore(
							first_score, second_score, third_score,
							school_score);

					
					String username = (String) session.getAttribute(ATTR_USER);

					abitur.setUsername(username);
					abitur.setFirstScore(first_score);
					abitur.setSecondScore(second_score);
					abitur.setThirdScore(third_score);
					abitur.setSchoolScore(school_score);
					abitur.setOverallScore(overall);
					abitur.setChosenFaculty(chosen_faculty);

					if (AbiturientLogic.createApplication(abitur)) {
						page = ConfigurationManager.getProperty(PAGE_SUCCESS);
						session.setAttribute("application", ATTR_APPLIC);
						session.removeAttribute("abiturient");

					} else {
						request.setAttribute("errorMessage",  MessageManager
							.getProperty(MESSAGE_ERROR));
						page = ConfigurationManager.getProperty(PAGE_ERROR);
					}

				} else {
					request.setAttribute("errorMessage", MessageManager
							.getProperty(MESSAGE_VALIDATION_FORMAT));

				}

			} else {
				request.setAttribute("errorMessage",
						MessageManager.getProperty(MESSAGE_NOT_FILLED));
			}

		}

		
		request.setAttribute("disciplines", list);

		return page;
	}

}
