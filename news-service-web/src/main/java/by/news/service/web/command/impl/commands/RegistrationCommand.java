package by.news.service.web.command.impl.commands;

import by.news.service.dao.impl.AbstractDAO;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.impl.UserServiceImpl;
import by.news.service.services.interf.UserService;
import by.news.service.web.command.impl.AbstractCommand;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegistrationCommand extends AbstractCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = ResourceBundle.getBundle("resources").getString("page.registration");
        User user = validate(request);
        if (user == null) {
            errorHandling(request);
            return nextPage;
        }
        int userID = registerUser(user);
        if (userID == 0) {
            errorHandling(request);
            return nextPage;
        }
        addUserToSession(request, userID);
        nextPage = ResourceBundle.getBundle("resources").getString("page.command.news.feed");
        return nextPage;
    }

    private int registerUser(User user) {
        int userID = 0;
        Log.debug("Get DAO");
        AbstractDAO<User, Integer> userDAO = UserDAOImpl.getInstance();
        Log.debug("Get Service");
        UserService userService = UserServiceImpl.getInstance();
        Log.debug("Set connection");
        userDAO.setConnection(connection);
        Log.debug("Dependency injection");
        userService.setUserGenericDAO(userDAO);
        try {
            Log.debug("Registering user");
            userID = userService.registerUser(user);
        } catch (ServiceException e) {
            Log.error("Cannot register user", e);
            e.printStackTrace();
        }
        Log.debug("Registration successful");
        return userID;
    }

    private User validate(HttpServletRequest request) {
        User user = null;
        Log.debug("Checking valid input");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = DigestUtils.md5Hex(request.getParameter("password"));
        if (Objects.equals(firstName, "") || Objects.equals(lastName, "") || Objects.equals(email, "") || Objects.equals(password, "")) {
            Log.debug("Input not valid. Empty form.");
        } else {
            user = new User(email, password, firstName, lastName);
        }
        return user;
    }

    private void errorHandling(HttpServletRequest request) {
        Log.warn("Wrong or empty input");
        request.setAttribute(
                ResourceBundle.getBundle("resources").getString("param.error.registration.input"),
                ResourceBundle.getBundle("content").getString("error.registration.input.message"));
    }

    private void addUserToSession(HttpServletRequest request, int userID) {
        HttpSession session = request.getSession();
        session.setAttribute("userID", userID);
    }
}