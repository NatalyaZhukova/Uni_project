package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.resource.MessageManager;

/**
 * A factory for creating ActionCommand objects.
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class ActionFactory {
	private static final String PARAM_COMMAND = "command";
	private static final String MESSAGE_WRONGACTION = "message.wrongaction";
	

	/**
	 * Define command.
	 *
	 * @param request the request
	 * @return the action command
	 */
	public ActionCommand defineCommand(HttpServletRequest request) {
		ActionCommand current = new EmptyCommand();
		
		String action = request.getParameter(PARAM_COMMAND);
		if (action == null || action.isEmpty()) {
			
			return current;
		}
		
		try {
			CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());

			current = currentEnum.getCurrentCommand();
		} catch (IllegalArgumentException e) {
			request.setAttribute("wrongAction",
					action + MessageManager.getProperty(MESSAGE_WRONGACTION));
		}
		return current;
	}
}
