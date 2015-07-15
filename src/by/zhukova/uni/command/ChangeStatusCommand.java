package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.resource.ConfigurationManager;

/**
 * The Class ChangeStatusCommand is command which changes status of user's
 * application
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ChangeStatusCommand implements ActionCommand {

	private static final String PARAM_STATUS = "status";
	private static final String PARAM_ID = "application_id";

	private final static String STATUS_APPROVED = "approved";
	private final static String STATUS_WAITING = "waiting";
	private final static String STATUS_DENIED = "denied";

	private final static String PAGE_SUCCESS = "path.page.success_change_stat";
	private final static String PAGE_ERROR = "path.page.error";

	private final static String MESSAGE_ERROR = "error.no_change_status";

	/**
	 * The method gets user's application status as a parameter and writes the
	 * new status to database
	 * 
	 * 
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		String current = request.getServletPath()+"?"+request.getQueryString();
		session.setAttribute("current", current);
		
		String page = null;
		int id = Integer.parseInt(request.getParameter(PARAM_ID));
		String statusId = request.getParameter(PARAM_STATUS);
		String status = "";
		switch (statusId) {
		case "1":
			status = STATUS_APPROVED;
			break;
		case "2":
			status = STATUS_WAITING;
			break;
		case "3":
			status = STATUS_DENIED;
		}

		Abiturient abitur = AbiturientLogic.getAbiturApplication(id);
		abitur.setStatus(status);
		if (AbiturientLogic.updateAbiturient(abitur)) {
			page = ConfigurationManager.getProperty(PAGE_SUCCESS);
		} else {
			request.setAttribute("errorMessage", MESSAGE_ERROR);
			page = ConfigurationManager.getProperty(PAGE_ERROR);
		}
		return page;
	}

}
