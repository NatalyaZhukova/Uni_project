package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Abiturient;
import by.zhukova.uni.entity.Faculty;
import by.zhukova.uni.logic.AbiturientLogic;
import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

/**
 * The Class ShowAbiturientsListCommand is command which shows list of user's
 * applications and defines who is allowed to enter the University.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ShowAbiturientsListCommand implements ActionCommand {

	private static final String PAGE_LIST = "path.page.abiturient_faculty";
	private static final String PAGE_OTHER_LIST = "path.page.applicat_list";
	private static final String PARAM_FACULTY_ID = "faculty";
	private static final String PARAM_STATUS = "stat";
	private static final String MESSAGE_NO_APPLIC = "message.no_application";
	private static final String MESSAGE_NO_APPLICS = "message.no_applications";
	private static final String STATUS_WAITING = "waiting";
	private static final String STATUS_DENIED = "denied";
	private static final String PARAM_PAGE = "p";

	/**
	 * The method gets list of user's application chosen by status given as a
	 * parameter. If the status is "waiting" or "denied", the method shows
	 * application list with links to application pages. In this case, list is
	 * divided by pages.
	 * 
	 *
	 * If the status is "approved"(which is defined by default), the method
	 * shows application list divided by faculty and sorted by sum of scores. In
	 * this case the method also defines who is allowed to enter the faculty.
	 *
	 * @see by.zhukova.uni.command.ActionCommand#execute(javax.servlet.http.HttpServletRequest)
	 * @return page defined page
	 */
	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String status = request.getParameter(PARAM_STATUS);
		if ((status != null) && ((status.equals(STATUS_WAITING)) || (status.equals(STATUS_DENIED)))) {

			List<Abiturient> list = AbiturientLogic.getAbitursByStatus(status);
			int quantApplic = list.size();

			if (quantApplic == 0) {
				request.setAttribute("message", MESSAGE_NO_APPLICS);
			}
			int pageNum;
			if (request.getParameter(PARAM_PAGE) == null) {
				pageNum = 1;
			} else {
				try {
					pageNum = Integer.parseInt(request.getParameter(PARAM_PAGE));
				} catch (NumberFormatException e) {
					pageNum = 1;
				}
			}

			int lastPage = AbiturientLogic.calculateLastPageNum(list);

			request.setAttribute("numpage", lastPage);
			List<Abiturient> listPart = AbiturientLogic.getFacultiesPage(pageNum, lastPage, list);

			request.setAttribute("status", status);
			request.setAttribute("abiturients", listPart);

			page = ConfigurationManager.getProperty(PAGE_OTHER_LIST);

		} else {
			page = ConfigurationManager.getProperty(PAGE_LIST);

			List<Faculty> facList = FacultyLogic.getFacultiesList();
			request.setAttribute("facList", facList);

			String facultyId = request.getParameter(PARAM_FACULTY_ID);
			int id;
			if (facultyId != null) {
				id = Integer.parseInt(facultyId);
			} else {
				id = facList.get(0).getId();
			}

			Faculty fac = FacultyLogic.getChosenFaculty(id);
			String facultyName = fac.getName();
			int plan = fac.getFacultyPlan();
			request.setAttribute("facultyName", facultyName);
			List<Abiturient> abiturients = AbiturientLogic.getApprovedAbitursByFaculty(id);
			int quantApplic = abiturients.size();
			int stopLine = 1;
			if (quantApplic == 0) {
				request.setAttribute("message", MESSAGE_NO_APPLIC);
			} else if (quantApplic <= plan) {
				stopLine = quantApplic;
			} else if (quantApplic > plan) {
				stopLine = plan;
			}
			request.setAttribute("plan", plan);
			request.setAttribute("stopLine", stopLine);
			request.setAttribute("applicNums", quantApplic);
			request.setAttribute("abiturients", abiturients);
		}

		return page;
	}

}
