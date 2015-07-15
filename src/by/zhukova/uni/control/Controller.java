/*
 * 
 */
package by.zhukova.uni.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import by.zhukova.uni.command.ActionCommand;
import by.zhukova.uni.command.ActionFactory;
import by.zhukova.uni.resource.ConfigurationManager;
import by.zhukova.uni.resource.MessageManager;

// TODO: Auto-generated Javadoc
/**
 * Class {@code Controller} is the servlet which manages commands and pages
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */

@WebServlet(name="University", urlPatterns = "/controller")
public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * Instantiates a new controller.
	 */
	public Controller() {

	}

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Accepts commands and sends to given page
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = null;

		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);

		page = command.execute(request);

		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);

			dispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("role") == null) {
				page = ConfigurationManager.getProperty("path.page.index");
			} else {
				page = ConfigurationManager.getProperty("path.page.main");
			}

			request.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}
