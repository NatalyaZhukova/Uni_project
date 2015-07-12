package by.zhukova.uni.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import by.zhukova.uni.command.ActionCommand;
import by.zhukova.uni.command.ActionFactory;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;


public class Controller extends HttpServlet {
	
	private static final String PAGE_INDEX = "path.page.index";
	private static final String PAGE_MAIN = "path.page.index";
	private static final String MESSAGE_NULL = "message.nullpage";
	private static final String ATTR_ROLE = "role";
	public Controller() {
		
	}
	
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String page = null;

		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		
		page = command.execute(request);
		
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(page);
		
			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession(true);
			if (session.getAttribute(ATTR_ROLE)==null){
			page = ConfigurationManager.getProperty(PAGE_INDEX);
			}
			else {
				page = ConfigurationManager.getProperty(PAGE_MAIN);
			}
		 
			request.getSession().setAttribute("nullPage",
					MessageManager.getProperty(MESSAGE_NULL));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
