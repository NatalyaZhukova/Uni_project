package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

import by.zhukova.uni.resource.MessageManager;

public class ActionFactory {
	private static final String PARAM_COMMAND = "command";
	

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
					action + MessageManager.getProperty("message.wrongaction"));
		}
		return current;
	}
}
