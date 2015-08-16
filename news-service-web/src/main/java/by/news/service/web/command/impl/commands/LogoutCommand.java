package by.news.service.web.command.impl.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.news.service.web.command.interf.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "http://localhost:8085/news-service-web/jsp/login.jsp";
	}

}
