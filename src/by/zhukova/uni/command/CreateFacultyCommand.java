package by.zhukova.uni.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.entity.Discipline;
import by.zhukova.uni.logic.DisciplineLogic;
import by.zhukova.uni.logic.Validation;

public class CreateFacultyCommand implements ActionCommand {
	private static final String PARAM_NAME = "faculty_name";
	private static final String PARAM_PLAN = "faculty_plan";
	private static final String PARAM_DISC1 = "disc1";
	private static final String PARAM_DISC2 = "disc2";
	private static final String PARAM_DISC3 = "disc3";

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		
		List<Discipline> list = DisciplineLogic.getAllDisciplines();
		request.setAttribute("discList", list);
		
		String name=request.getParameter(PARAM_NAME);
		String plan = request.getParameter(PARAM_PLAN);
		String disc1 = request.getParameter(PARAM_DISC1);
		String disc2 = request.getParameter(PARAM_DISC2);
		String disc3 = request.getParameter(PARAM_DISC3);
		
		if ((disc1!=null) || (disc2!=null) || (disc3!=null)) {
			
			if (Validation.isAllFieldFilled(name, plan)) {
				if Validation
			}
			else {
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return page;
	}

}
