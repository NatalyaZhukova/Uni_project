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


/**
 * The Class EditFacultyCommand is command which allows to edit faculty data
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class EditFacultyCommand implements ActionCommand {

	private static final String PAGE_ERROR = "path.page.error";
	private static final String PAGE_FORM = "path.page.editfaculty";
	private final static String PAGE_SUCCESS = "path.page.showfaculty";

	private static final String MESSAGE_INVALID_ID = "error.del_invalid_id";
	private static final String MESSAGE_VALIDATION_FORMAT = "validation.format";
	private static final String MESSAGE_NOT_FILLED = "validation.notfilled";
	private static final String MESSAGE_REPEAT = "validation.no_repeat";
	private static final String MESSAGE_ERROR = "error.no_upd_faculty";
	

	private static final String PARAM_ID = "id";
	private static final String PARAM_NAME = "faculty_name";
	private static final String PARAM_PLAN = "faculty_plan";
	private static final String PARAM_DISC1 = "disc1";
	private static final String PARAM_DISC2 = "disc2";
	private static final String PARAM_DISC3 = "disc3";

	/**
	 * The method gets the faculty data from the database, shows it on the form,
	 * gets data from it, validate and update it in the database
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getProperty(PAGE_FORM);
		
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);

		String facultyId = request.getParameter(PARAM_ID);
		try {
			int id = Integer.parseInt(facultyId);
			if (FacultyLogic.isIdExists(id)) {
				Faculty fac = FacultyLogic.getChosenFaculty(id);

				request.setAttribute("faculty", fac);
				List<Discipline> discList = DisciplineLogic.getAllDisciplines();
				request.setAttribute("discList", discList);
				if (FacultyLogic.isApplicationsExist(id)) {
					request.setAttribute("errorMessage", MESSAGE_ERROR);
					page = ConfigurationManager.getProperty(PAGE_ERROR);
				} else {
					if (request.getParameter(PARAM_DISC1) != null) {
						String name = request.getParameter(PARAM_NAME);
						String plan = request.getParameter(PARAM_PLAN);
						String disc1 = request.getParameter(PARAM_DISC1);
						String disc2 = request.getParameter(PARAM_DISC2);
						String disc3 = request.getParameter(PARAM_DISC3);

						if (Validation.isAllFieldFilled(name, plan)) {
							if (Validation.validFaculty(name, plan)) {
								if (Validation.noRepeatDisciplines(disc1, disc2, disc3)) {
									int firstDisc = Integer.parseInt(disc1);
									int secondDisc = Integer.parseInt(disc2);
									int thirdDisc = Integer.parseInt(disc3);
									int facultyPlan = Integer.parseInt(plan);

									fac.setName(name);
									fac.setFacultyPlan(facultyPlan);
									fac.setFirstDiscipline(firstDisc);
									fac.setSecondDiscipline(secondDisc);
									fac.setThirdDiscipline(thirdDisc);
									if (FacultyLogic.editFaculty(fac)) {

										List<Abiturient> list = AbiturientLogic.getApprovedAbitursByFaculty(id);
										int applicationsNum = list.size();
										List<Discipline> discFacList = DisciplineLogic.getFacultyDisciplines(fac);

										request.setAttribute("faculty", fac);
										request.setAttribute("discList", discFacList);
										request.setAttribute("applications", applicationsNum);
										page = ConfigurationManager.getProperty(PAGE_SUCCESS);
									} else {
										request.setAttribute("errorMessage", MESSAGE_ERROR);
										page = ConfigurationManager.getProperty(PAGE_ERROR);
									}

								} else {
									request.setAttribute("errorMessage", MESSAGE_REPEAT);
								}

							} else {
								request.setAttribute("errorMessage",
										MESSAGE_VALIDATION_FORMAT);
							}
						} else {
							request.setAttribute("errorMessage", MESSAGE_NOT_FILLED);
						}
					}

				}
			} else {
				request.setAttribute("errorMessage",MESSAGE_INVALID_ID);
				page = ConfigurationManager.getProperty(PAGE_ERROR);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", MESSAGE_INVALID_ID);
			page = ConfigurationManager.getProperty(PAGE_ERROR);
		}

		return page;
	}

}
