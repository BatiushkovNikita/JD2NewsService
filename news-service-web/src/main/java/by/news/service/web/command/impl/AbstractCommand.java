package by.news.service.web.command.impl;

import by.news.service.dao.pool.ConnectionPool;
import by.news.service.web.command.impl.commands.LoginCommand;
import by.news.service.web.command.interf.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.Objects;

public abstract class AbstractCommand implements Command {

    protected Connection connection = ConnectionPool.getInstance().getConnection();

    public Logger Log = LogManager.getLogger(LoginCommand.class.getName());

    public boolean isUserLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return  Objects.equals(session.getAttribute("userID"), null);
    }
}
