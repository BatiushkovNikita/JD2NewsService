package by.news.service.web.command.impl.commands;

import by.news.service.web.command.interf.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageNewsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "jsp/addnews.jsp";
	}

}
