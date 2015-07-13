package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.logic.Validation;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

/**
 * The Class ChooseFacultyCommand is command which shows form with part of
 * user's data and choice of faculty.
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ChooseFacultyCommand implements ActionCommand {

	private static final String PARAM_FIRST_NAME = "first_name";
	private static final String PARAM_MIDDLE_NAME = "middle_name";
	private static final String PARAM_LAST_NAME = "last_name";
	private static final String PARAM_FACULTY = "faculty";
	private static final String PAGE_CHOOSE_FACULTY = "path.page.choose_fac";
	private static final String PAGE_ADD_SCORES = "path.page.add_scores";

	private static final String MESSAGE_VALIDATION_FORMAT = "validation.format";
	private static final String MESSAGE_NOT_FILLED = "validation.notfilled";

	/**
	 * The method shows form, gets part of user's application data from it,
	 * validates and send it to defined page
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_CHOOSE_FACULTY);
		HttpSession session = request.getSession(true); // Locale

		List<Faculty> list = FacultyLogic.getFacultiesList();
		request.setAttribute("facList", list);

		String fName = request.getParameter(PARAM_FIRST_NAME);
		String mName = request.getParameter(PARAM_MIDDLE_NAME);
		String lName = request.getParameter(PARAM_LAST_NAME);

		if ((fName != null) || (mName != null) || (lName != null)) {

			if (Validation.isAllFieldFilled(fName, lName)) {
				if (Validation.validFIO(fName, mName, lName)) {
					Abiturient abitur = new Abiturient();
					abitur.setFirstName(fName);
					if (mName == null) {
						mName = "";
					}
					abitur.setMiddleName(mName);
					abitur.setLastName(lName);

					int facultyId = Integer.parseInt(request.getParameter(PARAM_FACULTY));
					abitur.setChosenFaculty(facultyId);
					Faculty fac = FacultyLogic.getChosenFaculty(facultyId);
					List<Discipline> discList = DisciplineLogic.getFacultyDisciplines(fac);
					session.setAttribute("abiturient", abitur);
					request.setAttribute("faculty_name", fac.getName());
					request.setAttribute("disciplines", discList);
					page = ConfigurationManager.getProperty(PAGE_ADD_SCORES);
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
