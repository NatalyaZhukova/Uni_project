package by.zhukova.uni.command;

import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {
String execute(HttpServletRequest request);
}