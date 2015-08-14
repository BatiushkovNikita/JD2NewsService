package by.news.service.web.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.news.service.web.command.interf.Command;

public class LoginCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String nextPage = "/Controller?command=news_feed";
		if (validate(request) == true) {
			
		} else {
			request.setAttribute("errorLoginInput", "Either the email or password is incorrect. Try again.");
		}

		return "/Controller?command=news_feed";
	}

	private void error(HttpServletRequest request) {
		
	}

	private boolean validate(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (email == "" || password == "") {
			return false;
		}
		return true;
	}
}
