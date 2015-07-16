package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;


/**
 * A factory for creating ActionCommand objects.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ActionFactory {
	private static final String PARAM_COMMAND = "command";
	static Logger logger = Logger.getLogger(ActionFactory.class);

	/**
	 * Define command.
	 *
	 * @param request
	 *            the request
	 * @return the action command
	 * @throws URLInputException 
	 */
	public ActionCommand defineCommand(HttpServletRequest request)  {
		ActionCommand current = new EmptyCommand();

		String action = request.getParameter(PARAM_COMMAND);
		if (action == null || action.isEmpty()) {

			return current;
		}

		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			logger.warn("wrong command: "+e.getMessage());	
		}
		return current;
	}
}
