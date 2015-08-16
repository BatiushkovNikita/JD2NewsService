package by.news.service.web.command.interf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.news.service.services.exception.ServiceException;

public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response);
}
