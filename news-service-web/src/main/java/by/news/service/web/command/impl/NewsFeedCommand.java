package by.news.service.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.news.service.web.command.interf.Command;

public class NewsFeedCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "jsp/newsfeed.jsp";
	}
}
