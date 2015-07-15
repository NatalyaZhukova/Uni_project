package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class DeleteFacultyCommand is command which allows to delete faculty from
 * database
 *
 * @author Natallya Zhukova
 * @since 1.0
 */
public class DeleteFacultyCommand implements ActionCommand {

	private static final String PAGE_ERROR = "path.page.error";
	private static final String PAGE_SUCCESS = "path.page.success_del_faculty";

	private static final String MESSAGE_INVALID_ID = "error.del_invalid_id";
	private static final String MESSAGE_ABITURS_EXIST = "error.del_abiturs_exist";
	private static final String MESSAGE_NO_DELETE = "error.no_del_faculty";

	/**
	 * The method checks identifier of faculty and, if it exists, deletes it.
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);

		String facultyId = request.getParameter("id");
		try {
			int id = Integer.parseInt(facultyId);
			if (FacultyLogic.isIdExists(id)) {
				if (FacultyLogic.isApplicationsExist(id)) {
					request.setAttribute("errorMessage", MESSAGE_ABITURS_EXIST);
					page = ConfigurationManager.getProperty(PAGE_ERROR);
				} else {
					if (FacultyLogic.deleteFaculty(id)) {
						page = ConfigurationManager.getProperty(PAGE_SUCCESS);
					} else {
						request.setAttribute("errorMessage", MESSAGE_NO_DELETE);
						page = ConfigurationManager.getProperty(PAGE_ERROR);
					}
				}
			} else {
				request.setAttribute("errorMessage", MESSAGE_INVALID_ID);
				page = ConfigurationManager.getProperty(PAGE_ERROR);
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", MESSAGE_INVALID_ID);
			page = ConfigurationManager.getProperty(PAGE_ERROR);
		}

		return page;
	}

}
