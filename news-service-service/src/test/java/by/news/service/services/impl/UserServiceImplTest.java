package by.news.service.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import by.news.service.dao.exception.DAOException;
import by.news.service.dao.impl.UserDAOImpl;
import by.news.service.dao.interf.GenericDAO;
import by.news.service.dao.interf.UserDAO;
import by.news.service.entity.Role;
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

	private GenericDAO<User, Integer> userGenericDAO;
	private UserDAO userDAO;
	private UserService userService = UserServiceImpl.getInstance();

	@Before
	public void setUp() throws Exception {
		userGenericDAO = context.mock(UserDAOImpl.class);
		userDAO = context.mock(UserDAO.class);
		userService.setUserGenericDAO(userGenericDAO);
		userService.setUserDAO(userDAO);
	}

	final int userID = 12345;
	final String email = "qwerty@mail.com";
	final String passwordMD5 = "d8578edf8458ce06fbc5bb76a58c5ca4";
	final String password = "qwerty";
	final String firstName = "Andrey";
	final String lastName = "Ivanov";
	final User user = new User(userID, email, password, firstName, lastName);
	final List<User> users = new ArrayList<User>();
	final List<Role> roles = new ArrayList<Role>();
	{
	roles.add(new Role(1, "admin"));
	roles.add(new Role(2, "user"));
	roles.add(new Role(3, "moderator"));
	users.add(new User(1234, "qwq", "d8sdsdus8dus8ud", "Petya", "Ivanov"));
	users.add(new User(38929, "AAA", "fdfsfsfsfs", "Sergey", "Petrov"));
	users.add(new User(15, "BBB", "21212ddsds", "Tanya", "Sergeeva"));
	}
	
	@Test
	public void testUserRegistration() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userGenericDAO).create(user);
				will(returnValue(userID));
			}
		});
		userService.registerUser(user);
	}
	
	@Test
	public void testUpdateUser() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userGenericDAO).update(user);
			}
		});
		userService.updateUser(user);
	}
	
	@Test
	public void testGetAllUsers() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userGenericDAO).getAll();
				will(returnValue(users));
			}
		});
		userService.getAllUsers();
	}
	
	@Test
	public void testGetUserRoles() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{
				oneOf(userDAO).getUserRoles(userID);
				will(returnValue(roles));
			}
		});
		userService.getUserRoles(userID);
	}
	
	@Test
	public void testAuthorizationUser() throws ServiceException, DAOException {
		context.checking(new Expectations() {
			{	
				oneOf(userDAO).getUserByEmailAndPassword(email, passwordMD5);
				will(returnValue(user));
			}
		});
		userService.authorizeUser(user);
	} 
}