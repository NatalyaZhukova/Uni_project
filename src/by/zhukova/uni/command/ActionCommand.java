package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;

/**
 * The Interface ActionCommand is template for commands.
 */
public interface ActionCommand {

/**
 * Execute.
 *
 * @param request the request
 * @return the string - the page path
 */
String execute(HttpServletRequest request);
}