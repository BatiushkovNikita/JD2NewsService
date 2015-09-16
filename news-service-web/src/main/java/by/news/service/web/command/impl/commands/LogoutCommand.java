package by.news.service.web.command.impl.commands;

import by.news.service.web.command.interf.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

public class LogoutCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String nextPage = ResourceBundle.getBundle("resources").getString("page.login");
        request.getSession().invalidate();
        return nextPage;
    }
}
