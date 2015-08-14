package by.news.service.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.news.service.web.command.impl.CommandFactory;
import by.news.service.web.command.interf.Command;

public class Controller extends HttpServlet {
	public static Logger Log = LogManager.getLogger(Controller.class.getName());

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		performAction(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		performAction(request, response);
	}

	private void performAction(HttpServletRequest request, HttpServletResponse response) {
		String paramCommand = request.getParameter("command");
		if (paramCommand == null) {
			throw new IllegalArgumentException("Param command is null");
		}
		
		Command command = CommandFactory.getCommand(paramCommand);
		String nextPage = command.execute(request, response);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
