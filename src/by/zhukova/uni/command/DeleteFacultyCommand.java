package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.logic.FacultyLogic;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

public class DeleteFacultyCommand implements ActionCommand {
	
	private static final String PAGE_ERROR = "path.page.error";
    private static final String PAGE_SUCCESS = "path.page.success_del_faculty";
    
    private static final String MESSAGE_INVALID_ID = "error.del_invalid_id";
    private static final String MESSAGE_ABITURS_EXIST = "error.del_abiturs_exist";
    private static final String MESSAGE_NO_DELETE = "error.no_del_faculty";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		String facultyId = request.getParameter("id");
		try {
		int id = Integer.parseInt(facultyId);
		if (FacultyLogic.isIdExists(id)) {
			if (FacultyLogic.isApplicationsExist(id)) {
				request.setAttribute("errorMessage", MessageManager.getProperty(MESSAGE_ABITURS_EXIST));
				page = ConfigurationManager.getProperty(PAGE_ERROR);
			}
			else {
				if (FacultyLogic.deleteFaculty(id)) {
				page = ConfigurationManager.getProperty(PAGE_SUCCESS); 
				}
				else {
					request.setAttribute("errorMessage", MessageManager.getProperty(MESSAGE_NO_DELETE));
					page = ConfigurationManager.getProperty(PAGE_ERROR);
				}
			}
		}
		else {
			request.setAttribute("errorMessage", MessageManager.getProperty(MESSAGE_INVALID_ID));
			page = ConfigurationManager.getProperty(PAGE_ERROR);
		}
		}
		catch (NumberFormatException e) {
			request.setAttribute("errorMessage", MessageManager.getProperty(MESSAGE_INVALID_ID));
			page = ConfigurationManager.getProperty(PAGE_ERROR);
		}
		
		return page;
	}

}
