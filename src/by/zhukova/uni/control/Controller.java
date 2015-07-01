package by.zhukova.uni.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import by.zhukova.uni.command.ActionCommand;
import by.zhukova.uni.command.ActionFactory;
import by.zhukova.uni.db.ConnectionPool;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	
	
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
			page = ConfigurationManager.getProperty("path.page.index");
			request.getSession().setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
