package by.news.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.entity.User;
import by.news.service.services.exception.ServiceException;
import by.news.service.services.interf.UserService;

public class UserServiceImplTest {
	@Rule
	public JUnitRuleMockery context = new JUnitRuleMockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private GenericDAO<User, Integer> userDao;
	private UserService userService;

	@Before
	public void setUp() throws Exception {
		userDao = context.mock(UserDAOImpl.class);
		userService = new UserServiceImpl(userDao);
	}

	final int userID = 12345;
	final String email = "qwerty@mail.com";
	final String password = "d8578edf8458ce06fbc5bb76a58c5ca4";
	final String firstName = "Andrey";
	final String lastName = "Ivanov";
	final User user = new User(userID, email, password, firstName, lastName);

	@Test
	public void registerUserTest() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userDao).create(user);
				will(returnValue(userID));
			}
		});
		userService.registerUser(user);
	}
	
	@Test
	public void updateUserTest() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userDao).update(user);
			}
		});
		userService.updateUser(user);
	}
	
	@Test
	public void getAllUsersTest() throws ServiceException, DAOException {
		final List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user);
		users.add(user);
		context.checking(new Expectations() {
			{
				oneOf(userDao).getAll();
				will(returnValue(users));
			}
		});
		userService.getAllUsers();
	}
}
