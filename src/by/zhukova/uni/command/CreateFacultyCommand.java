package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

/**
 * The Class CreateFacultyCommand is command which creates the new faculty and
 * writes it to database
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class CreateFacultyCommand implements ActionCommand {
	private static final String PARAM_NAME = "faculty_name";
	private static final String PARAM_PLAN = "faculty_plan";
	private static final String PARAM_DISC1 = "disc1";
	private static final String PARAM_DISC2 = "disc2";
	private static final String PARAM_DISC3 = "disc3";

	private static final String MESSAGE_VALIDATION_FORMAT = "validation.format";
	private static final String MESSAGE_NOT_FILLED = "validation.notfilled";
	private static final String MESSAGE_REPEAT = "validation.no_repeat";
	private static final String MESSAGE_ERROR = "error.no_faculty";
	private static final String PAGE_FORM = "path.page.createfaculty";
	private final static String PAGE_ERROR = "path.page.error";
	private final static String PAGE_SUCCESS = "path.page.success_faculty";

	/**
	 * The method shows form, gets user's data from it, validate and write to
	 * database
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_FORM);

		List<Discipline> list = DisciplineLogic.getAllDisciplines();
		request.setAttribute("discList", list);

		String name = request.getParameter(PARAM_NAME);
		String plan = request.getParameter(PARAM_PLAN);
		String disc1 = request.getParameter(PARAM_DISC1);
		String disc2 = request.getParameter(PARAM_DISC2);
		String disc3 = request.getParameter(PARAM_DISC3);

		if ((disc1 != null) || (disc2 != null) || (disc3 != null)) {

			if (Validation.isAllFieldFilled(name, plan)) {
				if (Validation.validFaculty(name, plan)) {
					if (Validation.noRepeatDisciplines(disc1, disc2, disc3)) {
						int firstDisc = Integer.parseInt(disc1);
						int secondDisc = Integer.parseInt(disc2);
						int thirdDisc = Integer.parseInt(disc3);
						int facultyPlan = Integer.parseInt(plan);
						Faculty fac = new Faculty();
						fac.setName(name);
						fac.setFacultyPlan(facultyPlan);
						fac.setFirstDiscipline(firstDisc);
						fac.setSecondDiscipline(secondDisc);
						fac.setThirdDiscipline(thirdDisc);
						if (FacultyLogic.createFaculty(fac)) {
							page = ConfigurationManager.getProperty(PAGE_SUCCESS);
						} else {
							request.setAttribute("errorMessage", MESSAGE_ERROR);
							page = ConfigurationManager.getProperty(PAGE_ERROR);
						}

					} else {
						request.setAttribute("errorMessage", MESSAGE_REPEAT);
					}

				} else {
					request.setAttribute("errorMessage", MESSAGE_VALIDATION_FORMAT);
				}
			} else {
				request.setAttribute("errorMessage", MESSAGE_NOT_FILLED);
			}

		}

		return page;
	}

}
