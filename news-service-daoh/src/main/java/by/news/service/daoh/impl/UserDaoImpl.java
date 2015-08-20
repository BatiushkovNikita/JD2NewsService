package by.news.service.daoh.impl;

import by.news.service.daoh.util.HibernateUtil;
import by.news.service.to.User;
import org.hibernate.Session;

public class UserDaoImpl {

	public User getUser(int id) {
		User user = null;
		Session session;
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		user = (User) session.get(User.class, id);
		//session.getTransaction().commit();
        //session.close();
		return user;
	}

}
