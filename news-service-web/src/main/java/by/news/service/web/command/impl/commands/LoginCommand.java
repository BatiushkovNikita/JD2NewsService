package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.UserServiceImpl;
import by.news.service.services.interf.UserService;
import by.news.service.web.command.impl.AbstractCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = ResourceBundle.getBundle("resources").getString("page.login");
        User user = validate(request);
        if (user == null) {
            errorHandling(request);
            return nextPage;
        }
        try {
            request.login(request.getParameter("email"), request.getParameter("password"));

        } catch (ServletException e) {
            e.printStackTrace();
        }
        if (request.getUserPrincipal() == null) {
            errorHandling(request);
            return nextPage;
        }
        nextPage = ResourceBundle.getBundle("resources").getString("page.command.news.feed");
        return nextPage;
    }

    private User validate(HttpServletRequest request) {
        User user = null;
        Log.debug("Checking valid input");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (Objects.equals(email, "") || Objects.equals(password, "")) {
            Log.debug("Input not valid. Empty form.");
        } else {
            user = new User(email, password);
        }
        return user;
    }

    private void errorHandling(HttpServletRequest request) {
        Log.warn("Wrong or empty input password and/or login");
        request.setAttribute(
                ResourceBundle.getBundle("resources").getString("param.error.login.input"),
                ResourceBundle.getBundle("content").getString("error.login.input.message"));
    }
}