package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.UserServiceImpl;
import by.news.service.services.interf.UserService;
import by.news.service.web.command.interf.Command;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String nextPage = "jsp/login.jsp";
		if (isValidUser(request)) {
			nextPage = "Controller?command=news_feed";
		} else {
			request.setAttribute("errorLoginInput", "Either the email or password is incorrect. Try again.");
		}

		return nextPage;
	}

	private boolean isValidUser(HttpServletRequest request) {
		boolean isValide = false;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if (Objects.equals(email, "") || Objects.equals(password, "")) {
			return false;
		}
		UserDAO userDAO = UserDAOImpl.getInstance();
		UserService userService = UserServiceImpl.getInstance();
		userService.setUserDAO(userDAO);
		User user = null;
		try {
			user = userService.authorizeUser(new User(email, password));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if (user != null) {
			isValide = true;
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUserID());
		}
		return isValide;
	}
}
