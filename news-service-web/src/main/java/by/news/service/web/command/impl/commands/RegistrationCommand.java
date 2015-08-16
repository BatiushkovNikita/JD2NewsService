package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.pool.ConnectionPool;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.UserServiceImpl;
import by.news.service.services.interf.UserService;
import by.news.service.web.command.interf.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.Objects;

public class RegistrationCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = "/jsp/registration.jsp";
        User user = validate(request);
        if (user != null) {
            Connection connection = ConnectionPool.getInstance().getConnection();
            AbstractDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
            UserService userService = UserServiceImpl.getInstance();
            userDAO.setConnection(connection);
            userService.setUserGenericDAO(userDAO);
            try {
                userService.registerUser(user);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            nextPage = "/jsp/newsfeed.jsp";
        } else {
            request.setAttribute("errorNewsInput", "Wrong input");
        }
        return nextPage;
    }

    private User validate(HttpServletRequest request) {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(email, "") || Objects.equals(password, "")) {
            return null;
        }
        return new User(email, password, firstName, lastName);
    }
}
